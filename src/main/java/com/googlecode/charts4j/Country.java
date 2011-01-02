/**
 *
 * The MIT License
 *
 * Copyright (c) 2011 the original author or authors.
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
 * A country on planet earth. Herein you can find all the country codes that are
 * detailed in <a
 * href="http://www.iso.org/iso/country_codes/iso_3166_code_lists/english_country_names_and_code_elements.htm">ISO
 * 3166</a>.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see PoliticalBoundary
 * @see USAState
 * @see MapChart
 * @see GeographicalArea
 */
public class Country extends AbstractPoliticalBoundary {

    /**
     * Country names.
     */
    public enum Name {
        /** Afghanistan. **/
        AFGHANISTAN("AF"),
        /** Aland_islands. **/
        ALAND_ISLANDS("AX"),
        /** Albania. **/
        ALBANIA("AL"),
        /** Algeria. **/
        ALGERIA("DZ"),
        /** American_samoa. **/
        AMERICAN_SAMOA("AS"),
        /** Andorra. **/
        ANDORRA("AD"),
        /** Angola. **/
        ANGOLA("AO"),
        /** Anguilla. **/
        ANGUILLA("AI"),
        /** Antarctica. **/
        ANTARCTICA("AQ"),
        /** Antigua_and_barbuda. **/
        ANTIGUA_AND_BARBUDA("AG"),
        /** Argentina. **/
        ARGENTINA("AR"),
        /** Armenia. **/
        ARMENIA("AM"),
        /** Aruba. **/
        ARUBA("AW"),
        /** Australia. **/
        AUSTRALIA("AU"),
        /** Austria. **/
        AUSTRIA("AT"),
        /** Azerbaijan. **/
        AZERBAIJAN("AZ"),
        /** Bahamas. **/
        BAHAMAS("BS"),
        /** Bahrain. **/
        BAHRAIN("BH"),
        /** Bangladesh. **/
        BANGLADESH("BD"),
        /** Barbados. **/
        BARBADOS("BB"),
        /** Belarus. **/
        BELARUS("BY"),
        /** Belgium. **/
        BELGIUM("BE"),
        /** Belize. **/
        BELIZE("BZ"),
        /** Benin. **/
        BENIN("BJ"),
        /** Bermuda. **/
        BERMUDA("BM"),
        /** Bhutan. **/
        BHUTAN("BT"),
        /** Bolivia. **/
        BOLIVIA("BO"),
        /** Bosnia_and_herzegovina. **/
        BOSNIA_AND_HERZEGOVINA("BA"),
        /** Botswana. **/
        BOTSWANA("BW"),
        /** Bouvet_island. **/
        BOUVET_ISLAND("BV"),
        /** Brazil. **/
        BRAZIL("BR"),
        /** British_indian_ocean_territory. **/
        BRITISH_INDIAN_OCEAN_TERRITORY("IO"),
        /** Brunei_darussalam. **/
        BRUNEI_DARUSSALAM("BN"),
        /** Bulgaria. **/
        BULGARIA("BG"),
        /** Burkina_faso. **/
        BURKINA_FASO("BF"),
        /** Burundi. **/
        BURUNDI("BI"),
        /** Cambodia. **/
        CAMBODIA("KH"),
        /** Cameroon. **/
        CAMEROON("CM"),
        /** Canada. **/
        CANADA("CA"),
        /** Cape_verde. **/
        CAPE_VERDE("CV"),
        /** Cayman_islands. **/
        CAYMAN_ISLANDS("KY"),
        /** Central_african_republic. **/
        CENTRAL_AFRICAN_REPUBLIC("CF"),
        /** Chad. **/
        CHAD("TD"),
        /** Chile. **/
        CHILE("CL"),
        /** China. **/
        CHINA("CN"),
        /** Christmas_island. **/
        CHRISTMAS_ISLAND("CX"),
        /** Cocos_keeling_islands. **/
        COCOS_KEELING_ISLANDS("CC"),
        /** Colombia. **/
        COLOMBIA("CO"),
        /** Comoros. **/
        COMOROS("KM"),
        /** Congo. **/
        CONGO("CG"),
        /** Congo_the_democratic_republic_of_the. **/
        CONGO_THE_DEMOCRATIC_REPUBLIC_OF_THE("CD"),
        /** Cook_islands. **/
        COOK_ISLANDS("CK"),
        /** Costa_rica. **/
        COSTA_RICA("CR"),
        /** Cote_d_ivoire. **/
        COTE_D_IVOIRE("CI"),
        /** Croatia. **/
        CROATIA("HR"),
        /** Cuba. **/
        CUBA("CU"),
        /** Cyprus. **/
        CYPRUS("CY"),
        /** Czech_republic. **/
        CZECH_REPUBLIC("CZ"),
        /** Denmark. **/
        DENMARK("DK"),
        /** Djibouti. **/
        DJIBOUTI("DJ"),
        /** Dominica. **/
        DOMINICA("DM"),
        /** Dominican_republic. **/
        DOMINICAN_REPUBLIC("DO"),
        /** Ecuador. **/
        ECUADOR("EC"),
        /** Egypt. **/
        EGYPT("EG"),
        /** El_salvador. **/
        EL_SALVADOR("SV"),
        /** Equatorial_guinea. **/
        EQUATORIAL_GUINEA("GQ"),
        /** Eritrea. **/
        ERITREA("ER"),
        /** Estonia. **/
        ESTONIA("EE"),
        /** Ethiopia. **/
        ETHIOPIA("ET"),
        /** Falkland_islands_malvinas_. **/
        FALKLAND_ISLANDS_MALVINAS_("FK"),
        /** Faroe_islands. **/
        FAROE_ISLANDS("FO"),
        /** Fiji. **/
        FIJI("FJ"),
        /** Finland. **/
        FINLAND("FI"),
        /** France. **/
        FRANCE("FR"),
        /** French_guiana. **/
        FRENCH_GUIANA("GF"),
        /** French_polynesia. **/
        FRENCH_POLYNESIA("PF"),
        /** French_southern_territories. **/
        FRENCH_SOUTHERN_TERRITORIES("TF"),
        /** Gabon. **/
        GABON("GA"),
        /** Gambia. **/
        GAMBIA("GM"),
        /** Georgia. **/
        GEORGIA("GE"),
        /** Germany. **/
        GERMANY("DE"),
        /** Ghana. **/
        GHANA("GH"),
        /** Gibraltar. **/
        GIBRALTAR("GI"),
        /** Greece. **/
        GREECE("GR"),
        /** Greenland. **/
        GREENLAND("GL"),
        /** Grenada. **/
        GRENADA("GD"),
        /** Guadeloupe. **/
        GUADELOUPE("GP"),
        /** Guam. **/
        GUAM("GU"),
        /** Guatemala. **/
        GUATEMALA("GT"),
        /** Guernsey. **/
        GUERNSEY("GG"),
        /** Guinea. **/
        GUINEA("GN"),
        /** Guinea_bissau. **/
        GUINEA_BISSAU("GW"),
        /** Guyana. **/
        GUYANA("GY"),
        /** Haiti. **/
        HAITI("HT"),
        /** Heard_island_and_mcdonald_islands. **/
        HEARD_ISLAND_AND_MCDONALD_ISLANDS("HM"),
        /** Holy_see_vatican_city_state_. **/
        HOLY_SEE_VATICAN_CITY_STATE_("VA"),
        /** Honduras. **/
        HONDURAS("HN"),
        /** Hong_kong. **/
        HONG_KONG("HK"),
        /** Hungary. **/
        HUNGARY("HU"),
        /** Iceland. **/
        ICELAND("IS"),
        /** India. **/
        INDIA("IN"),
        /** Indonesia. **/
        INDONESIA("ID"),
        /** Iran_islamic_republic_of. **/
        IRAN_ISLAMIC_REPUBLIC_OF("IR"),
        /** Iraq. **/
        IRAQ("IQ"),
        /** Ireland. **/
        IRELAND("IE"),
        /** Isle_of_man. **/
        ISLE_OF_MAN("IM"),
        /** Israel. **/
        ISRAEL("IL"),
        /** Italy. **/
        ITALY("IT"),
        /** Jamaica. **/
        JAMAICA("JM"),
        /** Japan. **/
        JAPAN("JP"),
        /** Jersey. **/
        JERSEY("JE"),
        /** Jordan. **/
        JORDAN("JO"),
        /** Kazakhstan. **/
        KAZAKHSTAN("KZ"),
        /** Kenya. **/
        KENYA("KE"),
        /** Kiribati. **/
        KIRIBATI("KI"),
        /** Korea_democratic_peoples_republic_of. **/
        KOREA_DEMOCRATIC_PEOPLES_REPUBLIC_OF("KP"),
        /** Korea_republic_of. **/
        KOREA_REPUBLIC_OF("KR"),
        /** Kuwait. **/
        KUWAIT("KW"),
        /** Kyrgyzstan. **/
        KYRGYZSTAN("KG"),
        /** Lao_peoples_democratic_republic. **/
        LAO_PEOPLES_DEMOCRATIC_REPUBLIC("LA"),
        /** Latvia. **/
        LATVIA("LV"),
        /** Lebanon. **/
        LEBANON("LB"),
        /** Lesotho. **/
        LESOTHO("LS"),
        /** Liberia. **/
        LIBERIA("LR"),
        /** Libyan_arab_jamahiriya. **/
        LIBYAN_ARAB_JAMAHIRIYA("LY"),
        /** Liechtenstein. **/
        LIECHTENSTEIN("LI"),
        /** Lithuania. **/
        LITHUANIA("LT"),
        /** Luxembourg. **/
        LUXEMBOURG("LU"),
        /** Macao. **/
        MACAO("MO"),
        /** Macedonia_the_former_yugoslav_republic_of. **/
        MACEDONIA_THE_FORMER_YUGOSLAV_REPUBLIC_OF("MK"),
        /** Madagascar. **/
        MADAGASCAR("MG"),
        /** Malawi. **/
        MALAWI("MW"),
        /** Malaysia. **/
        MALAYSIA("MY"),
        /** Maldives. **/
        MALDIVES("MV"),
        /** Mali. **/
        MALI("ML"),
        /** Malta. **/
        MALTA("MT"),
        /** Marshall_islands. **/
        MARSHALL_ISLANDS("MH"),
        /** Martinique. **/
        MARTINIQUE("MQ"),
        /** Mauritania. **/
        MAURITANIA("MR"),
        /** Mauritius. **/
        MAURITIUS("MU"),
        /** Mayotte. **/
        MAYOTTE("YT"),
        /** Mexico. **/
        MEXICO("MX"),
        /** Micronesia_federated_states_of. **/
        MICRONESIA_FEDERATED_STATES_OF("FM"),
        /** Moldova_republic_of. **/
        MOLDOVA_REPUBLIC_OF("MD"),
        /** Monaco. **/
        MONACO("MC"),
        /** Mongolia. **/
        MONGOLIA("MN"),
        /** Montenegro. **/
        MONTENEGRO("ME"),
        /** Montserrat. **/
        MONTSERRAT("MS"),
        /** Morocco. **/
        MOROCCO("MA"),
        /** Mozambique. **/
        MOZAMBIQUE("MZ"),
        /** Myanmar. **/
        MYANMAR("MM"),
        /** Namibia. **/
        NAMIBIA("NA"),
        /** Nauru. **/
        NAURU("NR"),
        /** Nepal. **/
        NEPAL("NP"),
        /** Netherlands. **/
        NETHERLANDS("NL"),
        /** Netherlands_antilles. **/
        NETHERLANDS_ANTILLES("AN"),
        /** New_caledonia. **/
        NEW_CALEDONIA("NC"),
        /** New_zealand. **/
        NEW_ZEALAND("NZ"),
        /** Nicaragua. **/
        NICARAGUA("NI"),
        /** Niger. **/
        NIGER("NE"),
        /** Nigeria. **/
        NIGERIA("NG"),
        /** Niue. **/
        NIUE("NU"),
        /** Norfolk_island. **/
        NORFOLK_ISLAND("NF"),
        /** Northern_mariana_islands. **/
        NORTHERN_MARIANA_ISLANDS("MP"),
        /** Norway. **/
        NORWAY("NO"),
        /** Oman. **/
        OMAN("OM"),
        /** Pakistan. **/
        PAKISTAN("PK"),
        /** Palau. **/
        PALAU("PW"),
        /** Palestinian_territory_occupied. **/
        PALESTINIAN_TERRITORY_OCCUPIED("PS"),
        /** Panama. **/
        PANAMA("PA"),
        /** Papua_new_guinea. **/
        PAPUA_NEW_GUINEA("PG"),
        /** Paraguay. **/
        PARAGUAY("PY"),
        /** Peru. **/
        PERU("PE"),
        /** Philippines. **/
        PHILIPPINES("PH"),
        /** Pitcairn. **/
        PITCAIRN("PN"),
        /** Poland. **/
        POLAND("PL"),
        /** Portugal. **/
        PORTUGAL("PT"),
        /** Puerto_rico. **/
        PUERTO_RICO("PR"),
        /** Qatar. **/
        QATAR("QA"),
        /** Reunion. **/
        REUNION("RE"),
        /** Romania. **/
        ROMANIA("RO"),
        /** Russian_federation. **/
        RUSSIAN_FEDERATION("RU"),
        /** Rwanda. **/
        RWANDA("RW"),
        /** Saint_barthelemy. **/
        SAINT_BARTHELEMY("BL"),
        /** Saint_helena. **/
        SAINT_HELENA("SH"),
        /** Saint_kitts_and_nevis. **/
        SAINT_KITTS_AND_NEVIS("KN"),
        /** Saint_lucia. **/
        SAINT_LUCIA("LC"),
        /** Saint_martin. **/
        SAINT_MARTIN("MF"),
        /** Saint_pierre_and_miquelon. **/
        SAINT_PIERRE_AND_MIQUELON("PM"),
        /** Saint_vincent_and_the_grenadines. **/
        SAINT_VINCENT_AND_THE_GRENADINES("VC"),
        /** Samoa. **/
        SAMOA("WS"),
        /** San_marino. **/
        SAN_MARINO("SM"),
        /** Sao_tome_and_principe. **/
        SAO_TOME_AND_PRINCIPE("ST"),
        /** Saudi_arabia. **/
        SAUDI_ARABIA("SA"),
        /** Senegal. **/
        SENEGAL("SN"),
        /** Serbia. **/
        SERBIA("RS"),
        /** Seychelles. **/
        SEYCHELLES("SC"),
        /** Sierra_leone. **/
        SIERRA_LEONE("SL"),
        /** Singapore. **/
        SINGAPORE("SG"),
        /** Slovakia. **/
        SLOVAKIA("SK"),
        /** Slovenia. **/
        SLOVENIA("SI"),
        /** Solomon_islands. **/
        SOLOMON_ISLANDS("SB"),
        /** Somalia. **/
        SOMALIA("SO"),
        /** South_africa. **/
        SOUTH_AFRICA("ZA"),
        /** South_georgia_and_the_south_sandwich_islands. **/
        SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS("GS"),
        /** Spain. **/
        SPAIN("ES"),
        /** Sri_lanka. **/
        SRI_LANKA("LK"),
        /** Sudan. **/
        SUDAN("SD"),
        /** Suriname. **/
        SURINAME("SR"),
        /** Svalbard_and_jan_mayen. **/
        SVALBARD_AND_JAN_MAYEN("SJ"),
        /** Swaziland. **/
        SWAZILAND("SZ"),
        /** Sweden. **/
        SWEDEN("SE"),
        /** Switzerland. **/
        SWITZERLAND("CH"),
        /** Syrian_arab_republic. **/
        SYRIAN_ARAB_REPUBLIC("SY"),
        /** Taiwan_province_of_china. **/
        TAIWAN_PROVINCE_OF_CHINA("TW"),
        /** Tajikistan. **/
        TAJIKISTAN("TJ"),
        /** Tanzania_united_republic_of. **/
        TANZANIA_UNITED_REPUBLIC_OF("TZ"),
        /** Thailand. **/
        THAILAND("TH"),
        /** Timor_leste. **/
        TIMOR_LESTE("TL"),
        /** Togo. **/
        TOGO("TG"),
        /** Tokelau. **/
        TOKELAU("TK"),
        /** Tonga. **/
        TONGA("TO"),
        /** Trinidad_and_tobago. **/
        TRINIDAD_AND_TOBAGO("TT"),
        /** Tunisia. **/
        TUNISIA("TN"),
        /** Turkey. **/
        TURKEY("TR"),
        /** Turkmenistan. **/
        TURKMENISTAN("TM"),
        /** Turks_and_caicos_islands. **/
        TURKS_AND_CAICOS_ISLANDS("TC"),
        /** Tuvalu. **/
        TUVALU("TV"),
        /** Uganda. **/
        UGANDA("UG"),
        /** Ukraine. **/
        UKRAINE("UA"),
        /** United_arab_emirates. **/
        UNITED_ARAB_EMIRATES("AE"),
        /** United_kingdom. **/
        UNITED_KINGDOM("GB"),
        /** United_states. **/
        UNITED_STATES("US"),
        /** United_states_minor_outlying_islands. **/
        UNITED_STATES_MINOR_OUTLYING_ISLANDS("UM"),
        /** Uruguay. **/
        URUGUAY("UY"),
        /** Uzbekistan. **/
        UZBEKISTAN("UZ"),
        /** Vanuatu. **/
        VANUATU("VU"),
        /** Venezuela. **/
        VENEZUELA("VE"),
        /** Viet_nam. **/
        VIET_NAM("VN"),
        /** Virgin_islands_british. **/
        VIRGIN_ISLANDS_BRITISH("VG"),
        /** Virgin_islands_us. **/
        VIRGIN_ISLANDS_US("VI"),
        /** Wallis_and_futuna. **/
        WALLIS_AND_FUTUNA("WF"),
        /** Western_sahara. **/
        WESTERN_SAHARA("EH"),
        /** Yemen. **/
        YEMEN("YE"),
        /** Zambia. **/
        ZAMBIA("ZM"),
        /** Zimbabwe. **/
        ZIMBABWE("ZW");

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
     * Country code.
     *
     */
    public enum Code {
        /** Afghanistan. **/
        AF,
        /** Aland_islands. **/
        AX,
        /** Albania. **/
        AL,
        /** Algeria. **/
        DZ,
        /** American_samoa. **/
        AS,
        /** Andorra. **/
        AD,
        /** Angola. **/
        AO,
        /** Anguilla. **/
        AI,
        /** Antarctica. **/
        AQ,
        /** Antigua_and_barbuda. **/
        AG,
        /** Argentina. **/
        AR,
        /** Armenia. **/
        AM,
        /** Aruba. **/
        AW,
        /** Australia. **/
        AU,
        /** Austria. **/
        AT,
        /** Azerbaijan. **/
        AZ,
        /** Bahamas. **/
        BS,
        /** Bahrain. **/
        BH,
        /** Bangladesh. **/
        BD,
        /** Barbados. **/
        BB,
        /** Belarus. **/
        BY,
        /** Belgium. **/
        BE,
        /** Belize. **/
        BZ,
        /** Benin. **/
        BJ,
        /** Bermuda. **/
        BM,
        /** Bhutan. **/
        BT,
        /** Bolivia. **/
        BO,
        /** Bosnia_and_herzegovina. **/
        BA,
        /** Botswana. **/
        BW,
        /** Bouvet_island. **/
        BV,
        /** Brazil. **/
        BR,
        /** British_indian_ocean_territory. **/
        IO,
        /** Brunei_darussalam. **/
        BN,
        /** Bulgaria. **/
        BG,
        /** Burkina_faso. **/
        BF,
        /** Burundi. **/
        BI,
        /** Cambodia. **/
        KH,
        /** Cameroon. **/
        CM,
        /** Canada. **/
        CA,
        /** Cape_verde. **/
        CV,
        /** Cayman_islands. **/
        KY,
        /** Central_african_republic. **/
        CF,
        /** Chad. **/
        TD,
        /** Chile. **/
        CL,
        /** China. **/
        CN,
        /** Christmas_island. **/
        CX,
        /** Cocos_keeling_islands. **/
        CC,
        /** Colombia. **/
        CO,
        /** Comoros. **/
        KM,
        /** Congo. **/
        CG,
        /** Congo_the_democratic_republic_of_the. **/
        CD,
        /** Cook_islands. **/
        CK,
        /** Costa_rica. **/
        CR,
        /** Cote_d_ivoire. **/
        CI,
        /** Croatia. **/
        HR,
        /** Cuba. **/
        CU,
        /** Cyprus. **/
        CY,
        /** Czech_republic. **/
        CZ,
        /** Denmark. **/
        DK,
        /** Djibouti. **/
        DJ,
        /** Dominica. **/
        DM,
        /** Dominican_republic. **/
        DO,
        /** Ecuador. **/
        EC,
        /** Egypt. **/
        EG,
        /** El_salvador. **/
        SV,
        /** Equatorial_guinea. **/
        GQ,
        /** Eritrea. **/
        ER,
        /** Estonia. **/
        EE,
        /** Ethiopia. **/
        ET,
        /** Falkland_islands_malvinas_. **/
        FK,
        /** Faroe_islands. **/
        FO,
        /** Fiji. **/
        FJ,
        /** Finland. **/
        FI,
        /** France. **/
        FR,
        /** French_guiana. **/
        GF,
        /** French_polynesia. **/
        PF,
        /** French_southern_territories. **/
        TF,
        /** Gabon. **/
        GA,
        /** Gambia. **/
        GM,
        /** Georgia. **/
        GE,
        /** Germany. **/
        DE,
        /** Ghana. **/
        GH,
        /** Gibraltar. **/
        GI,
        /** Greece. **/
        GR,
        /** Greenland. **/
        GL,
        /** Grenada. **/
        GD,
        /** Guadeloupe. **/
        GP,
        /** Guam. **/
        GU,
        /** Guatemala. **/
        GT,
        /** Guernsey. **/
        GG,
        /** Guinea. **/
        GN,
        /** Guinea_bissau. **/
        GW,
        /** Guyana. **/
        GY,
        /** Haiti. **/
        HT,
        /** Heard_island_and_mcdonald_islands. **/
        HM,
        /** Holy_see_vatican_city_state_. **/
        VA,
        /** Honduras. **/
        HN,
        /** Hong_kong. **/
        HK,
        /** Hungary. **/
        HU,
        /** Iceland. **/
        IS,
        /** India. **/
        IN,
        /** Indonesia. **/
        ID,
        /** Iran_islamic_republic_of. **/
        IR,
        /** Iraq. **/
        IQ,
        /** Ireland. **/
        IE,
        /** Isle_of_man. **/
        IM,
        /** Israel. **/
        IL,
        /** Italy. **/
        IT,
        /** Jamaica. **/
        JM,
        /** Japan. **/
        JP,
        /** Jersey. **/
        JE,
        /** Jordan. **/
        JO,
        /** Kazakhstan. **/
        KZ,
        /** Kenya. **/
        KE,
        /** Kiribati. **/
        KI,
        /** Korea_democratic_peoples_republic_of. **/
        KP,
        /** Korea_republic_of. **/
        KR,
        /** Kuwait. **/
        KW,
        /** Kyrgyzstan. **/
        KG,
        /** Lao_peoples_democratic_republic. **/
        LA,
        /** Latvia. **/
        LV,
        /** Lebanon. **/
        LB,
        /** Lesotho. **/
        LS,
        /** Liberia. **/
        LR,
        /** Libyan_arab_jamahiriya. **/
        LY,
        /** Liechtenstein. **/
        LI,
        /** Lithuania. **/
        LT,
        /** Luxembourg. **/
        LU,
        /** Macao. **/
        MO,
        /** Macedonia_the_former_yugoslav_republic_of. **/
        MK,
        /** Madagascar. **/
        MG,
        /** Malawi. **/
        MW,
        /** Malaysia. **/
        MY,
        /** Maldives. **/
        MV,
        /** Mali. **/
        ML,
        /** Malta. **/
        MT,
        /** Marshall_islands. **/
        MH,
        /** Martinique. **/
        MQ,
        /** Mauritania. **/
        MR,
        /** Mauritius. **/
        MU,
        /** Mayotte. **/
        YT,
        /** Mexico. **/
        MX,
        /** Micronesia_federated_states_of. **/
        FM,
        /** Moldova_republic_of. **/
        MD,
        /** Monaco. **/
        MC,
        /** Mongolia. **/
        MN,
        /** Montenegro. **/
        ME,
        /** Montserrat. **/
        MS,
        /** Morocco. **/
        MA,
        /** Mozambique. **/
        MZ,
        /** Myanmar. **/
        MM,
        /** Namibia. **/
        NA,
        /** Nauru. **/
        NR,
        /** Nepal. **/
        NP,
        /** Netherlands. **/
        NL,
        /** Netherlands_antilles. **/
        AN,
        /** New_caledonia. **/
        NC,
        /** New_zealand. **/
        NZ,
        /** Nicaragua. **/
        NI,
        /** Niger. **/
        NE,
        /** Nigeria. **/
        NG,
        /** Niue. **/
        NU,
        /** Norfolk_island. **/
        NF,
        /** Northern_mariana_islands. **/
        MP,
        /** Norway. **/
        NO,
        /** Oman. **/
        OM,
        /** Pakistan. **/
        PK,
        /** Palau. **/
        PW,
        /** Palestinian_territory_occupied. **/
        PS,
        /** Panama. **/
        PA,
        /** Papua_new_guinea. **/
        PG,
        /** Paraguay. **/
        PY,
        /** Peru. **/
        PE,
        /** Philippines. **/
        PH,
        /** Pitcairn. **/
        PN,
        /** Poland. **/
        PL,
        /** Portugal. **/
        PT,
        /** Puerto_rico. **/
        PR,
        /** Qatar. **/
        QA,
        /** Reunion. **/
        RE,
        /** Romania. **/
        RO,
        /** Russian_federation. **/
        RU,
        /** Rwanda. **/
        RW,
        /** Saint_barthelemy. **/
        BL,
        /** Saint_helena. **/
        SH,
        /** Saint_kitts_and_nevis. **/
        KN,
        /** Saint_lucia. **/
        LC,
        /** Saint_martin. **/
        MF,
        /** Saint_pierre_and_miquelon. **/
        PM,
        /** Saint_vincent_and_the_grenadines. **/
        VC,
        /** Samoa. **/
        WS,
        /** San_marino. **/
        SM,
        /** Sao_tome_and_principe. **/
        ST,
        /** Saudi_arabia. **/
        SA,
        /** Senegal. **/
        SN,
        /** Serbia. **/
        RS,
        /** Seychelles. **/
        SC,
        /** Sierra_leone. **/
        SL,
        /** Singapore. **/
        SG,
        /** Slovakia. **/
        SK,
        /** Slovenia. **/
        SI,
        /** Solomon_islands. **/
        SB,
        /** Somalia. **/
        SO,
        /** South_africa. **/
        ZA,
        /** South_georgia_and_the_south_sandwich_islands. **/
        GS,
        /** Spain. **/
        ES,
        /** Sri_lanka. **/
        LK,
        /** Sudan. **/
        SD,
        /** Suriname. **/
        SR,
        /** Svalbard_and_jan_mayen. **/
        SJ,
        /** Swaziland. **/
        SZ,
        /** Sweden. **/
        SE,
        /** Switzerland. **/
        CH,
        /** Syrian_arab_republic. **/
        SY,
        /** Taiwan_province_of_china. **/
        TW,
        /** Tajikistan. **/
        TJ,
        /** Tanzania_united_republic_of. **/
        TZ,
        /** Thailand. **/
        TH,
        /** Timor_leste. **/
        TL,
        /** Togo. **/
        TG,
        /** Tokelau. **/
        TK,
        /** Tonga. **/
        TO,
        /** Trinidad_and_tobago. **/
        TT,
        /** Tunisia. **/
        TN,
        /** Turkey. **/
        TR,
        /** Turkmenistan. **/
        TM,
        /** Turks_and_caicos_islands. **/
        TC,
        /** Tuvalu. **/
        TV,
        /** Uganda. **/
        UG,
        /** Ukraine. **/
        UA,
        /** United_arab_emirates. **/
        AE,
        /** United_kingdom. **/
        GB,
        /** United_states. **/
        US,
        /** United_states_minor_outlying_islands. **/
        UM,
        /** Uruguay. **/
        UY,
        /** Uzbekistan. **/
        UZ,
        /** Vanuatu. **/
        VU,
        /** Venezuela. **/
        VE,
        /** Viet_nam. **/
        VN,
        /** Virgin_islands_british. **/
        VG,
        /** Virgin_islands_us. **/
        VI,
        /** Wallis_and_futuna. **/
        WF,
        /** Western_sahara. **/
        EH,
        /** Yemen. **/
        YE,
        /** Zambia. **/
        ZM,
        /** Zimbabwe. **/
        ZW;
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
    public Country(final Name name, final int color) {
        super(name.toString(), color);
    }

    /**
     * Construct this implementation of {@link PoliticalBoundary}.
     *
     * @param code
     *            Supply a country code.
     *
     * @param color
     *            Define an integer from 0 to 100 that will be positioned along
     *            the color gradient. The integer you provide here will be
     *            interpolated with the color gradient that you defined in
     *            {@link MapChart#setColorGradient(Color defaultColor, Color... colorGradient)}
     */
    public Country(final Code code, final int color) {
        super(code.toString(), color);
    }

}
