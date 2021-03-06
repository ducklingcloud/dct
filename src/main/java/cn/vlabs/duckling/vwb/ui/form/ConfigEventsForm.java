/*
 * Copyright (c) 2008-2016 Computer Network Information Center (CNIC), Chinese Academy of Sciences.
 * 
 * This file is part of Duckling project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 *
 */
/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package cn.vlabs.duckling.vwb.ui.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 08-27-2007
 * 
 * XDoclet definition:
 * @struts.form name="searchCLBForm"
 */
public class ConfigEventsForm extends ActionForm {
	/*
	 * Generated Methods
	 */

    private static final long serialVersionUID = 1L;  

    /** pattern property */
    private String type;
    private String typename;
    private int eventid;
    private String eventname;
    private boolean enable;
    private int score;
    
    
    public ConfigEventsForm() {
        //field=AUTHOR; 
    }
    
    /*
     * Generated Methods
     */

    /** 
     * Method validate
     * @param mapping
     * @param request
     * @return ActionErrors
     */
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        // TODO Auto-generated method stub
        return null;
        //return null;
    }
    
        
    /** 
     * Method reset
     * @param mapping
     * @param request
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        // TODO Auto-generated method stub
        //this.field=AUTHOR;
        this.type=null;        
        this.typename=null;
        this.eventid=0;
        this.eventname=null;
        this.enable=false;
        this.score=0;
    }

    /**
     * Returns the pattern.
     * 
     * @return String
     */
    public String getType() {
        return type;
    }

    public void setType(String typeid) {
        this.type = typeid;
    }

    public String getTypeName() {
        return typename;
    }

    public void setTypeName(String name) {
        this.typename = name;
    }

    public int getEventID() {
        return eventid;
    }

    public void setEventID(int id) {
        this.eventid = id;
    }
    
    public String getEventName() {
        return eventname;
    }

    public void setEventName(String name) {
        this.eventname = name;
    }
    
    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean bool) {
        this.enable = bool;
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int num) {
        this.score = num;
    }
}