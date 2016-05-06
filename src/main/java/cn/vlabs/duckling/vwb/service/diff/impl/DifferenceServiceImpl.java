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

package cn.vlabs.duckling.vwb.service.diff.impl;

import org.apache.log4j.Logger;

import cn.vlabs.duckling.vwb.VWBContext;
import cn.vlabs.duckling.vwb.service.diff.DifferenceService;

/**
 * Load, initialize and delegate to the DiffProvider that will actually do the
 * work.
 * 
 * @author Yong Ke
 */
public class DifferenceServiceImpl implements DifferenceService {
	private static final Logger log = Logger
			.getLogger(DifferenceServiceImpl.class);

	private DiffProvider provider;

	/**
	 * Returns valid XHTML string to be used in any way you please.
	 * 
	 * @param context
	 *            The VWB Context
	 * @param firstWikiText
	 *            The old text
	 * @param secondWikiText
	 *            the new text
	 * @return XHTML, or empty string, if no difference detected.
	 */
	public String makeDiff(VWBContext context, int pageid, int verFirst,
			int verSecond) {
		String diff = null;
		try {
			diff = provider.makeDiffHtml(context, pageid, verFirst, verSecond);

			if (diff == null)
				diff = "";
		} catch (NoPageContentFoundException e) {
			diff = "Failed to create a diff, check the logs.";
			log.warn(e.getMessage());
		} catch (Exception e) {
			diff = "Failed to create a diff, check the logs.";
			log.warn(diff, e);
		}
		return diff;
	}

	/**
	 * @param provider
	 *            the provider to set
	 */
	public void setProvider(DiffProvider provider) {
		this.provider = provider;
	}
}