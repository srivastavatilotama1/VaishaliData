if(cf.vars.cancel_impression[cf.adunits[cf.vars.current_adunit].creative_id]){
	cf.fall_back(cf.vars.current_adunit, cf.adunits[cf.vars.current_adunit].bringback_url, cf.adunits[cf.vars.current_adunit].priority_start);
}else{
	cf.pixel(cf.adunits[cf.vars.current_adunit].imp_url);
}