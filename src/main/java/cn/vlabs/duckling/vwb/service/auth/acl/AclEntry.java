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

package cn.vlabs.duckling.vwb.service.auth.acl;

import java.io.Serializable;
import java.security.Permission;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;


/**
 * Implementation of a JSPWiki AclEntry.
 * 
 * @date Feb 3, 2010
 * @author zzb
 */
public class AclEntry implements Serializable{
	private static final long serialVersionUID = 1L;
	private Vector<Permission> m_permissions = new Vector<Permission>();
	private Principal m_principal;

	/**
	 * Constructs a new AclEntryImpl instance.
	 */
	public AclEntry() {
	}

	/**
	 * Adds the specified permission to this ACL entry. The permission
	 * <em>must</em> be of type
	 * {@link cn.vlabs.duckling.vwb.service.auth.permissions.ecyrd.jspwiki.auth.permissions.PagePermission}
	 * . Note: An entry can have multiple permissions.
	 * 
	 * @param permission
	 *            the permission to be associated with the principal in this
	 *            entry
	 * @return <code>true</code> if the permission was added, <code>false</code>
	 *         if the permission was already part of this entry's permission
	 *         set, and <code>false</code> if the permission is not of type
	 *         PagePermission
	 */
	public synchronized boolean addPermission(Permission permission) {
		if (findPermission(permission) == null) {
			m_permissions.add(permission);
			return true;
		}

		return false;
	}

	/**
	 * Checks if the specified permission is part of the permission set in this
	 * entry.
	 * 
	 * @param permission
	 *            the permission to be checked for.
	 * @return true if the permission is part of the permission set in this
	 *         entry, false otherwise.
	 */
	public boolean checkPermission(Permission permission) {
		return findPermission(permission) != null;
	}

	/**
	 * Returns the principal for which permissions are granted by this ACL
	 * entry. Returns null if there is no principal set for this entry yet.
	 * 
	 * @return the principal associated with this entry.
	 */
	public synchronized Principal getPrincipal() {
		return m_principal;
	}

	/**
	 * Returns an enumeration of the permissions in this ACL entry.
	 * 
	 * @return an enumeration of the permissions
	 */
	public Enumeration<Permission> permissions() {
		return m_permissions.elements();
	}

	/**
	 * Removes the specified permission from this ACL entry.
	 * 
	 * @param permission
	 *            the permission to be removed from this entry.
	 * @return true if the permission is removed, false if the permission was
	 *         not part of this entry's permission set.
	 */
	public synchronized boolean removePermission(Permission permission) {
		Permission p = findPermission(permission);

		if (p != null) {
			m_permissions.remove(p);
			return true;
		}

		return false;
	}

	/**
	 * Specifies the principal for which permissions are granted or denied by
	 * this ACL entry. If a principal was already set for this ACL entry, false
	 * is returned, otherwise true is returned.
	 * 
	 * @param user
	 *            the principal to be set for this entry
	 * @return true if the principal is set, false if there was already a
	 *         principal set for this entry
	 */
	public synchronized boolean setPrincipal(Principal user) {
		// if ( m_principal != null || user == null )
		if (user == null)
			return false;

		m_principal = user;

		return true;
	}

	/**
	 * Returns a string representation of the contents of this ACL entry.
	 * 
	 * @return a string representation of the contents.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();

		Principal p = getPrincipal();

		sb.append("[AclEntry ALLOW " + (p != null ? p.getName() : "null"));
		sb.append(" ");

		for (Iterator<Permission> i = m_permissions.iterator(); i.hasNext();) {
			Permission pp = (Permission) i.next();

			sb.append(pp.toString());
			sb.append(",");
		}

		sb.append("]");

		return sb.toString();
	}

	/**
	 * Looks through the permission list and finds a permission that matches the
	 * permission.
	 */
	private Permission findPermission(Permission p) {
		for (Iterator<Permission> i = m_permissions.iterator(); i.hasNext();) {
			Permission pp = (Permission) i.next();

			if (pp.implies(p)) {
				return pp;
			}
		}

		return null;
	}
}
