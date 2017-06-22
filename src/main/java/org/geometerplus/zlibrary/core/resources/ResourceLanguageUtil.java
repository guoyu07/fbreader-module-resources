/*
 * Copyright (C) 2009-2017 FBReader.ORG Limited <contact@fbreader.org>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.zlibrary.core.resources;

import java.util.Locale;

import org.fbreader.util.Language;

public abstract class ResourceLanguageUtil {
	public static Language language(String code) {
		return language(code, ZLResource.resource("language"));
	}

	public static Language language(String code, ZLResource root) {
		if (code == null) {
			return null;
		}

		final ZLResource resource = root.getResource(code);
		if (resource.hasValue()) {
			return new Language(code, resource.getValue());
		} else {
			try {
				return new Language(code, new Locale(code).getDisplayLanguage());
			} catch (Throwable t) {
				return null;
			}
		}
	}
}
