/**
 *
 * The MIT License
 *
 * Copyright (c) 2008 the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.googlecode.charts4j;

/**
 * A state in the USA. Herein you can find all the US States.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see PoliticalBoundary
 * @see Country
 * @see MapChart
 */
public class USAState extends AbstractPoliticalBoundary {
    /**
     * USA State name.
     */
    public enum Name {
        /** Alabama. **/
        ALABAMA("AL"),
        /** Alaska. **/
        ALASKA("AK"),
        /** Arizona. **/
        ARIZONA("AZ"),
        /** Arkansas. **/
        ARKANSAS("AR"),
        /** California. **/
        CALIFORNIA("CA"),
        /** Colorado. **/
        COLORADO("CO"),
        /** Connecticut. **/
        CONNECTICUT("CT"),
        /** Delaware. **/
        DELAWARE("DE"),
        /** Florida. **/
        FLORIDA("FL"),
        /** Georgia. **/
        GEORGIA("GA"),
        /** Hawaii. **/
        HAWAII("HI"),
        /** Idaho. **/
        IDAHO("ID"),
        /** Illinois. **/
        ILLINOIS("IL"),
        /** Indiana. **/
        INDIANA("IN"),
        /** Iowa. **/
        IOWA("IA"),
        /** Kansas. **/
        KANSAS("KS"),
        /** Kentucky. **/
        KENTUCKY("KY"),
        /** Louisiana. **/
        LOUISIANA("LA"),
        /** Maine. **/
        MAINE("ME"),
        /** Maryland. **/
        MARYLAND("MD"),
        /** Massachusetts. **/
        MASSACHUSETTS("MA"),
        /** Michigan. **/
        MICHIGAN("MI"),
        /** Minnesota. **/
        MINNESOTA("MN"),
        /** Mississippi. **/
        MISSISSIPPI("MS"),
        /** Missouri. **/
        MISSOURI("MO"),
        /** Montana. **/
        MONTANA("MT"),
        /** Nebraska. **/
        NEBRASKA("NE"),
        /** Nevada. **/
        NEVADA("NV"),
        /** New_hampshire. **/
        NEW_HAMPSHIRE("NH"),
        /** New_jersey. **/
        NEW_JERSEY("NJ"),
        /** New_mexico. **/
        NEW_MEXICO("NM"),
        /** New_york. **/
        NEW_YORK("NY"),
        /** North_carolina. **/
        NORTH_CAROLINA("NC"),
        /** North_dakota. **/
        NORTH_DAKOTA("ND"),
        /** Ohio. **/
        OHIO("OH"),
        /** Oklahoma. **/
        OKLAHOMA("OK"),
        /** Oregon. **/
        OREGON("OR"),
        /** Pennsylvania. **/
        PENNSYLVANIA("PA"),
        /** Rhode_island. **/
        RHODE_ISLAND("RI"),
        /** South_carolina. **/
        SOUTH_CAROLINA("SC"),
        /** South_dakota. **/
        SOUTH_DAKOTA("SD"),
        /** Tennessee. **/
        TENNESSEE("TN"),
        /** Texas. **/
        TEXAS("TX"),
        /** Utah. **/
        UTAH("UT"),
        /** Vermont. **/
        VERMONT("VT"),
        /** Virginia. **/
        VIRGINIA("VA"),
        /** Washington. **/
        WASHINGTON("WA"),
        /** West_virginia. **/
        WEST_VIRGINIA("WV"),
        /** Wisconsin. **/
        WISCONSIN("WI"),
        /** Wyoming. **/
        WYOMING("WY");

        /** String for the Google Chart API parameter. */
        private final String name;

        /**
         * Instantiating enum.
         *
         * @param name
         *            the string for the Google Chart API parameter
         */
        private Name(final String name) {
            this.name = name;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * USA state name code.
     *
     */
    public enum Code {
        /** Alabama. **/
        AL,
        /** Alaska. **/
        AK,
        /** Arizona. **/
        AZ,
        /** Arkansas. **/
        AR,
        /** California. **/
        CA,
        /** Colorado. **/
        CO,
        /** Connecticut. **/
        CT,
        /** Delaware. **/
        DE,
        /** Florida. **/
        FL,
        /** Georgia. **/
        GA,
        /** Hawaii. **/
        HI,
        /** Idaho. **/
        ID,
        /** Illinois. **/
        IL,
        /** Indiana. **/
        IN,
        /** Iowa. **/
        IA,
        /** Kansas. **/
        KS,
        /** Kentucky. **/
        KY,
        /** Louisiana. **/
        LA,
        /** Maine. **/
        ME,
        /** Maryland. **/
        MD,
        /** Massachusetts. **/
        MA,
        /** Michigan. **/
        MI,
        /** Minnesota. **/
        MN,
        /** Mississippi. **/
        MS,
        /** Missouri. **/
        MO,
        /** Montana. **/
        MT,
        /** Nebraska. **/
        NE,
        /** Nevada. **/
        NV,
        /** New_hampshire. **/
        NH,
        /** New_jersey. **/
        NJ,
        /** New_mexico. **/
        NM,
        /** New_york. **/
        NY,
        /** North_carolina. **/
        NC,
        /** North_dakota. **/
        ND,
        /** Ohio. **/
        OH,
        /** Oklahoma. **/
        OK,
        /** Oregon. **/
        OR,
        /** Pennsylvania. **/
        PA,
        /** Rhode_island. **/
        RI,
        /** South_carolina. **/
        SC,
        /** South_dakota. **/
        SD,
        /** Tennessee. **/
        TN,
        /** Texas. **/
        TX,
        /** Utah. **/
        UT,
        /** Vermont. **/
        VT,
        /** Virginia. **/
        VA,
        /** Washington. **/
        WA,
        /** West_virginia. **/
        WV,
        /** Wisconsin. **/
        WI,
        /** Wyoming. **/
        WY;
    }

    /**
     * Construct this implementation of {@link PoliticalBoundary}.
     *
     * @param name
     *            Supply a country name.
     *
     * @param color
     *            Define an integer from 0 to 100 that will be positioned along
     *            the color gradient. The integer you provide here will be
     *            interpolated with the color gradient that you defined in
     *            {@link MapChart#setColorGradient(Color defaultColor, Color... colorGradient)}
     */
    public USAState(final Name name, final int color) {
        super(name.toString(), color);
    }

    /**
     * Construct this implementation of {@link PoliticalBoundary}.
     *
     * @param code
     *            Supply a country name.
     *
     * @param color
     *            Define an integer from 0 to 100 that will be positioned along
     *            the color gradient. The integer you provide here will be
     *            interpolated with the color gradient that you defined in
     *            {@link MapChart#setColorGradient(Color defaultColor, Color... colorGradient)}
     */
    public USAState(final Code code, final int color) {
        super(code.toString(), color);
    }
}
