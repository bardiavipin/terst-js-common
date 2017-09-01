package com.netcracker.scp.lab.setup.businessdelegate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.netcracker.scp.lab.constants.Constants;
import com.netcracker.scp.model.Events;
import com.netcracker.scp.model.LabDetails;
import com.netcracker.scp.service.EventsLocalServiceUtil;
import com.netcracker.scp.service.LabDetailsLocalService;
import com.netcracker.scp.service.LabDetailsLocalServiceUtil;
import com.netcracker.scp.vo.DescUrlVO;
import org.springframework.stereotype.Component;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class LabSetupBusinessDelegate {

	public static final Log LOGGER = LogFactoryUtil.getLog(LabSetupBusinessDelegate.class);
	/**
	 * Add or update Lab Records
	 * @param request
	 * @param themeDisplay
	 * @return LabDetails
	 * @throws PortalException
	 * @throws SystemException
	 */
	public LabDetails addUpdateLabDetails(ActionRequest request, ThemeDisplay themeDisplay,LabDetailsLocalService labDetailsLocalService) throws PortalException, SystemException{
		LOGGER.info("addUpdateLabDetails : " + Constants.START);
		LabDetails labDetail = getLabDetails( request,labDetailsLocalService );
		
		if(labDetail.getLabId()==0){
			// Primary Key generation
			labDetail.setLabId(CounterLocalServiceUtil.increment(LabDetails.class.getName()));
			labDetail.setCreateDate(new Date());
		}
		// Audit Fields
		labDetail.setUserId(themeDisplay.getUserId());
		labDetail.setGroupId(themeDisplay.getScopeGroupId());
		labDetail.setCompanyId(themeDisplay.getCompanyId());
		labDetail.setUserName(themeDisplay.getUser().getFullName());
		labDetail.setModifiedDate(new Date());
		
		// Basic Information about Lab
		labDetail.setTitle(ParamUtil.getString(request, "title"));
		labDetail.setDescription(ParamUtil.getString(request, "description"));
		labDetail.setPortalUrl(ParamUtil.getString(request, "portalUrl"));
		labDetail.setNcUrl(ParamUtil.getString(request, "ncUrl"));
		labDetail.setBassLink(ParamUtil.getString(request, "bassLink"));
		labDetail.setVimUser(ParamUtil.getString(request, "vimUser"));
		labDetail.setVimPass(ParamUtil.getString(request, "vimPass"));
		labDetail.setSdnUser(ParamUtil.getString(request, "sdnUser"));
		labDetail.setSdnPass(ParamUtil.getString(request, "sdnPass"));
		
		// Lab Status
		labDetail.setStatus(true);
		
		// Reepatable url fields
		labDetail.setOtherUrl(createJsonFromRequest(request));
		
		labDetail = LabDetailsLocalServiceUtil.updateLabDetails(labDetail);
		
		LOGGER.info("addUpdateLabDetails : " + Constants.END);
    	return labDetail;
	}
	
	/**
	 * This method process action request and fetch parameters to create json out of them. 
	 * @param request
	 * @return String
	 */
	private String createJsonFromRequest(ActionRequest request){
		LOGGER.info("createJsonFromRequest : " + Constants.START);
		String urlIndexesString =  ParamUtil.getString(request,"urlIndexes");
		 
		 int[] urlIndexes = StringUtil.split(urlIndexesString, 0);

		 StringBuilder builder = new StringBuilder();
		 builder.append("{ \"descUrl\" : [ ");
		 for (int urlIndex =0; urlIndex < urlIndexes.length;urlIndex++) {
             String description = ParamUtil.getString(request, "urlDesc" + urlIndexes[urlIndex]);
             String url = ParamUtil.getString(request, "url" + urlIndexes[urlIndex]);
             if(!description.isEmpty() && !url.isEmpty()){
            	 builder.append("{\"desc\" : \"" + description + "\",");
            	 builder.append("\"url\" : \"" + HttpUtil.encodeURL(url)  + "\"}");
            	 builder.append(",");
             }
		 }
		 
		 builder.append("] }");

		 String json = builder.toString();
		 json = json.replace("},]", "}]");
		 
		 LOGGER.info("createJsonFromRequest : " + Constants.END);
		 return json;
	}
	
	/**
	 * Static method to convert json into list of objects. 
	 * @param jsonString
	 * @return List<DescUrlVO>
	 */
	public static List<DescUrlVO> convertObjectFromJson(String jsonString){
		LOGGER.info("convertObjectFromJson : " + Constants.START);
		if(Validator.isNull(jsonString)){
			return dummyList();
		}
		JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject)jsonParser.parse(jsonString);
        JsonArray jsonArr = jo.getAsJsonArray("descUrl");
        
        Type listOfTestObject = new com.google.gson.reflect.TypeToken<List<DescUrlVO>>(){}.getType();
        List<DescUrlVO> yourList = new Gson().fromJson(jsonArr, listOfTestObject);
       /* Gson googleJson = new Gson();
        ArrayList<DescUrlVO> jsonObjList = (ArrayList<DescUrlVO>) googleJson.fromJson(jsonArr, ArrayList.class);
        */
        LOGGER.info("List size is : "+yourList.size());
        
        if(yourList.size()==0){
        	return dummyList();
        }
        LOGGER.info("convertObjectFromJson : " + Constants.END);
        return yourList;
	}
	
	private static List<DescUrlVO> dummyList(){
		List<DescUrlVO> descUrlVOs = new ArrayList<DescUrlVO>();
		descUrlVOs.add(new DescUrlVO());
		return descUrlVOs;
	}
	/**
	 * Get Lab Details
	 * @param request
	 * @return LabDetails
	 * @throws PortalException
	 * @throws SystemException
	 */
	public LabDetails getLabDetails(PortletRequest request, LabDetailsLocalService labDetailsLocalService) throws PortalException, SystemException {
		LOGGER.info("getLabDetails : " + Constants.START);
    	long labId = ParamUtil.getLong(request, "labId");
    	LabDetails labDetail = null;
    	if(labId!=0){
    		labDetail = LabDetailsLocalServiceUtil.getLabDetails(labId);
    	} else {
    		labDetail = labDetailsLocalService.getLabDetails();
    	}
    	LOGGER.info("getLabDetails : " + Constants.END);
    	return labDetail;
    }
	
	/**
	 * Delete selected lab records inculding all of the events.
	 * @param labId
	 * @param companyId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void deleteLabs(long labId, long companyId) throws SystemException, PortalException{
		LOGGER.info("deleteLabs : " + Constants.START);
    	List<Events> events = EventsLocalServiceUtil.findByLab(labId, companyId, -1, -1);
    	for(Events event:events){
    		EventsLocalServiceUtil.deleteEvents(event);
    	}
    	LabDetailsLocalServiceUtil.deleteLabDetails(labId);
    	LOGGER.info("deleteLabs : " + Constants.END);
    }
}
