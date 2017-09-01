package com.netcracker.scp.lab.setup;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.netcracker.scp.lab.constants.Constants;
import com.netcracker.scp.lab.servicetracker.EventServiceTracker;
import com.netcracker.scp.lab.servicetracker.LabDetailsServiceTracker;
import com.netcracker.scp.lab.setup.businessdelegate.LabSetupBusinessDelegate;
import com.netcracker.scp.model.LabDetails;
import com.netcracker.scp.service.LabDetailsLocalService;
import com.netcracker.scp.service.persistence.LabDetailsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.annotation.PostConstruct;
import javax.portlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("VIEW")
public class LabSetupController {


	private LabSetupBusinessDelegate labSetupBusinessDelegate;
	public void setLabSetupBusinessDelegate(LabSetupBusinessDelegate labSetupBusinessDelegate) {
		this.labSetupBusinessDelegate = labSetupBusinessDelegate;
	}

	public static final Log LOGGER = LogFactoryUtil.getLog(LabSetupController.class);

	EventServiceTracker eventServiceTracker=null;
	LabDetailsServiceTracker labDetailsServiceTracker=null;

	@PostConstruct
	public void init() {
		System.out.println(" PostConstruct ");
		eventServiceTracker = new EventServiceTracker(this);
		eventServiceTracker.open();

		labDetailsServiceTracker=new LabDetailsServiceTracker(this);
		labDetailsServiceTracker.open();
	}
	
    @RenderMapping
    public String render(Model model, RenderRequest request, RenderResponse response) throws SystemException, PortalException {
    	LOGGER.info("render : " + Constants.START);
    	fillModel(model, request);
    	LOGGER.info("render : " + Constants.END);
		Map map=new HashMap();
		map.put("H","helloo");
		map.put("W","wallo");
		map.put("D","Dalloo");
		map.put("B","Bello");
		map.put("J","jalloo");
		map.put("W","wallo  wallo");
		model.addAttribute("mapObj",map);
        return "labsetup/view";
    }
    
    @RenderMapping(params = "action=labRecord")
    public String renderLabRecord(Model model, RenderRequest request, RenderResponse response) throws SystemException, PortalException {
    	LOGGER.info("renderLabRecord : " + Constants.START);
		if(!labDetailsServiceTracker.isEmpty()) {
			LabDetailsLocalService labDetailsLocalService = labDetailsServiceTracker.getService();
			model.addAttribute("labDetail", labSetupBusinessDelegate.getLabDetails(request,labDetailsLocalService));
		}
    	LOGGER.info("renderLabRecord : " + Constants.END);
        return "labsetup/labRecord";
    }
    
    @ActionMapping(params = "action=delete")
    public void delete(Model model, ActionRequest request, ActionResponse response) throws IOException, PortalException, SystemException{
    	LOGGER.info("delete : " + Constants.START);
    	long labId = ParamUtil.getLong(request, "labId");
    	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    	labSetupBusinessDelegate.deleteLabs(labId, themeDisplay.getCompanyId());
    	LOGGER.info("delete : " + Constants.END);
    	//response.sendRedirect(themeDisplay.getURLCurrent().split("\\?")[0]);
    }
    
    @ActionMapping(params = "action=deleteAll")
    public void deleteAll(Model model, ActionRequest request, ActionResponse response) throws IOException, PortalException, SystemException{
    	LOGGER.info("deleteAll : " + Constants.START);
    	long[] labIds = ParamUtil.getLongValues(request, "rowIds");
    	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    	for(long labId:labIds){
    		labSetupBusinessDelegate.deleteLabs(labId, themeDisplay.getCompanyId());
    	}
    	LOGGER.info("deleteAll : " + Constants.END);
    	//response.sendRedirect(themeDisplay.getURLCurrent().split("\\?")[0]);
    }
    
    @ActionMapping(params = "action=activation")
    public void deactivate(Model model, ActionRequest request, ActionResponse response) throws IOException, PortalException, SystemException{
    	LOGGER.info("deactivate : " + Constants.START);
    	long labId = ParamUtil.getLong(request, "labId");
    	Boolean status = ParamUtil.getBoolean(request, "activate");
    	if(!labDetailsServiceTracker.isEmpty()) {
			LabDetailsLocalService labDetailsLocalService=labDetailsServiceTracker.getService();
			LabDetails labDetails = labDetailsLocalService.getLabDetails(labId);
			labDetails.setStatus(status);
			labDetailsLocalService.updateLabDetails(labDetails);
		}
    	
    	LOGGER.info("deactivate : " + Constants.END);
    	//response.sendRedirect(themeDisplay.getURLCurrent().split("\\?")[0]);
    }
    
    @ActionMapping(params = "action=addUpdateLab")
    public void addUpdateLab(Model model, ActionRequest request, ActionResponse response) throws IOException, PortalException, SystemException{
    	LOGGER.info("addUpdateLab : " + Constants.START);
    	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if(!labDetailsServiceTracker.isEmpty()) {
			LabDetailsLocalService labDetailsLocalService = labDetailsServiceTracker.getService();
			labSetupBusinessDelegate.addUpdateLabDetails(request, themeDisplay,labDetailsLocalService);
		}
    	
    	LOGGER.info("addUpdateLab : " + Constants.END);
    	//response.sendRedirect(themeDisplay.getURLCurrent().split("\\?")[0]);
    }
    
    private void fillModel(Model model, PortletRequest request) throws PortalException, SystemException {
		if(!labDetailsServiceTracker.isEmpty()) {
			LabDetailsLocalService labDetailsLocalService = labDetailsServiceTracker.getService();
			LabDetailsUtil.clearCache();
			model.addAttribute("labDetails", labDetailsLocalService.getLabDetailses(-1, -1));
			model.addAttribute("total", labDetailsLocalService.getLabDetailsesCount());
		}
    }
}
