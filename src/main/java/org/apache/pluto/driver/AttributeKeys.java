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

package org.apache.pluto.driver;

/**
 * Constants used as attribute keys to bind values to servlet context or servlet
 * request.
 *
 * @version 1.0
 * @since Sep 25, 2004
 */
public class AttributeKeys {

    /**
     * Attribute Key used to bind the application's driver config to the
     * ServletContext.
     */
    public static final String DRIVER_CONFIG = "driverConfig";
    
    public static final String VWB_CONFIG="vwbconfig";
    /**
     * Attribute Key used to bind the application's driver admin config
     * to the ServletContext.
     */
    public static final String DRIVER_ADMIN_CONFIG = "driverAdminConfig";

    /**
     * Attribute Key used to bind the application's portlet container to the
     * ServletContext.
     */
    public static final String PORTLET_CONTAINER = "portletContainer";

    /** Attribute key used to bind the current page to servlet request. */
    public static final String CURRENT_PAGE = "currentPage";

    /** Attribute key used to bind the portlet title to servlet request. */
    public static final String PORTLET_TITLE =
    		"org.apache.pluto.driver.DynamicPortletTitle";

    public static final String PORTAL_URL_PARSER = "PORTAL_URL_PARSER";

    // Constructor -------------------------------------------------------------

    /**
     * Private constructor that prevents external instantiation.
     */
    private AttributeKeys() {

    }
}

