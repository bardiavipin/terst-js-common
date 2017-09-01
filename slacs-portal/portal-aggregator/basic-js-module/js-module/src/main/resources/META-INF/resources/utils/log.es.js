import $ from 'jquery';

export default function(msg) {
	document.getElementById("context").innerHTML =  document.getElementById("context").innerHTML + " > " + msg ;
}