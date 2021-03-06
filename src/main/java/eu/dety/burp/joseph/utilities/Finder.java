/**
 * JOSEPH - JavaScript Object Signing and Encryption Pentesting Helper
 * Copyright (C) 2016 Dennis Detering
 * <p>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package eu.dety.burp.joseph.utilities;

import burp.IParameter;
import burp.IRequestInfo;
import eu.dety.burp.joseph.gui.PreferencesPanel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Help functions to find and extract JWS and JWE patterns.
 * 
 * @author Dennis Detering
 * @version 1.0
 */
public class Finder {

    /**
     * Check whether given JWS candidate matches regex pattern
     * 
     * @param candidate
     *            String containing the JWS candidate value.
     * @return boolean whether regex pattern matched or not.
     */
    public static boolean checkJwsPattern(String candidate) {
        if (candidate == null || candidate.isEmpty())
            return false;

        Pattern jwsPattern = Pattern.compile("(ey[a-zA-Z0-9\\-_]+\\.ey[a-zA-Z0-9\\-_]+\\.([a-zA-Z0-9\\-_]+)?)$", Pattern.CASE_INSENSITIVE);
        Matcher jwsMatcher = jwsPattern.matcher(candidate);

        return jwsMatcher.find();
    }

    /**
     * Check whether given JWE candidate matches regex pattern
     * 
     * @param candidate
     *            String containing the JWE candidate value.
     * @return boolean whether regex pattern matched or not.
     */
    public static boolean checkJwePattern(String candidate) {
        if (candidate == null || candidate.isEmpty())
            return false;

        Pattern jwePattern = Pattern.compile("(ey[a-zA-Z0-9\\-_]+\\.[a-zA-Z0-9\\-_]+\\.[a-zA-Z0-9\\-_]+\\.[a-zA-Z0-9\\-_]+\\.[a-zA-Z0-9\\-_]+)$",
                Pattern.CASE_INSENSITIVE);
        Matcher jweMatcher = jwePattern.matcher(candidate);

        return jweMatcher.find();
    }

    /**
     * Return JOSE value if given candidate matches regex pattern
     * 
     * @param candidate
     *            String containing the JOSE candidate value.
     * @return String with matched JOSE value.
     */
    public static String getJoseValue(String candidate) {
        Pattern jwsPattern = Pattern.compile("(ey[a-zA-Z0-9\\-_]+\\.[a-zA-Z0-9\\-_]+\\.([a-zA-Z0-9\\-_]+)?([a-zA-Z0-9\\-_\\.]+)*)", Pattern.CASE_INSENSITIVE);
        Matcher jwsMatcher = jwsPattern.matcher(candidate);

        return (jwsMatcher.find()) ? jwsMatcher.group(0) : null;
    }

    /**
     * Return {@link JoseParameter} object if JWS value could be found in parameters or HTTP headers
     * 
     * @param requestInfo
     *            {@link IRequestInfo} object
     * @return {@link JoseParameter} with found JWS parameter/header
     */
    public static JoseParameter checkHeaderAndParameterForJwsPattern(IRequestInfo requestInfo) {
        JoseParameter joseParameter = null;

        // Search for JOSE header
        for (String header : requestInfo.getHeaders()) {
            if (PreferencesPanel.getParameterNames().contains(header.split(":", 2)[0]) && checkJwsPattern(header)) {
                joseParameter = new JoseParameter(header, JoseParameter.JoseType.JWS);
            }
        }

        // Search for JOSE parameter
        for (IParameter param : requestInfo.getParameters()) {
            if (PreferencesPanel.getParameterNames().contains(param.getName()) && checkJwsPattern(param.getValue())) {
                joseParameter = new JoseParameter(param, JoseParameter.JoseType.JWS);
            }
        }

        return joseParameter;
    }

    /**
     * Return {@link JoseParameter} object if JWE value could be found in parameters or HTTP headers
     * 
     * @param requestInfo
     *            {@link IRequestInfo} object
     * @return {@link JoseParameter} with found JWE parameter/header
     */
    public static JoseParameter checkHeaderAndParameterForJwePattern(IRequestInfo requestInfo) {
        JoseParameter joseParameter = null;

        // Search for JOSE header
        for (String header : requestInfo.getHeaders()) {
            if (PreferencesPanel.getParameterNames().contains(header.split(":", 2)[0]) && checkJwePattern(header)) {
                joseParameter = new JoseParameter(header, JoseParameter.JoseType.JWE);
            }
        }

        // Search for JOSE parameter
        for (IParameter param : requestInfo.getParameters()) {
            if (PreferencesPanel.getParameterNames().contains(param.getName()) && checkJwePattern(param.getValue())) {
                joseParameter = new JoseParameter(param, JoseParameter.JoseType.JWE);
            }
        }

        return joseParameter;
    }

}
