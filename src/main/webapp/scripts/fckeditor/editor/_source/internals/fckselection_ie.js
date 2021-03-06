﻿/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net
 * Copyright (C) 2003-2008 Frederico Caldeira Knabben
 *
 * == BEGIN LICENSE ==
 *
 * Licensed under the terms of any of the following licenses at your
 * choice:
 *
 *  - GNU General Public License Version 2 or later (the "GPL")
 *    http://www.gnu.org/licenses/gpl.html
 *
 *  - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 *    http://www.gnu.org/licenses/lgpl.html
 *
 *  - Mozilla Public License Version 1.1 or later (the "MPL")
 *    http://www.mozilla.org/MPL/MPL-1.1.html
 *
 * == END LICENSE ==
 *
 * Active selection functions. (IE specific implementation)
 */

// The "nodeTagName" parameter must be UPPER CASE.
FCKSelection.Save = function(bLock) {
	// Ensures the editor has the selection focus. (#1801)
	FCK.Focus();

	var editorDocument = FCK.EditorDocument;

	if (!editorDocument)
		return;

	if (this.locked)
		return;

	this.locked = !!bLock;
	var range = this._GetSelectionRange();

	// Ensure that the range comes from the editor document.
	if (range) {
		if (range.parentElement
				&& FCKTools.GetElementDocument(range.parentElement()) != editorDocument)
			range = null;
		else if (range.item
				&& FCKTools.GetElementDocument(range.item(0)) != editorDocument)
			range = null;
	}

	this.SelectionData = range;
};

FCKSelection.GetType = function() {
	if (FCKBrowserInfo.IsGecko){
		// By default set the type to "Text".
		var type = 'Text';
		
		// Check if the actual selection is a Control (IMG, TABLE, HR, etc...).
		
		var sel;
		try {
			sel = this.GetSelection();
		} catch (e) {
		}
		
		if (sel && sel.rangeCount == 1) {
			var range = sel.getRangeAt(0);
			if (range.startContainer == range.endContainer
					&& (range.endOffset - range.startOffset) == 1
					&& range.startContainer.nodeType == 1
					&& FCKListsLib.StyleObjectElements[range.startContainer.childNodes[range.startOffset].nodeName
					                                   .toLowerCase()]) {
				type = 'Control';
			}
		}
	}else{
		var oSel = this.GetSelection();
		return oSel.type;
	}

	return type;
};