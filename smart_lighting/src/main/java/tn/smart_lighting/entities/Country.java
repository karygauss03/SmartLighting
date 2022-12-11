package tn.smart_lighting.entities;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public enum Country {
    AFG((short)4,"AF","AFG","Afghanistan","Kabul"),
    ALB((short)8,"AL","ALB","Albania","Tirana"),
    ATA((short)10,"AQ","ATA","Antarctica","ATA"),
    DZA((short)12,"DZ","DZA","Algeria","Algiers"),
    ASM((short)16,"AS","ASM","American Samoa","Pago Pago"),
    AND((short)20,"AD","AND","Andorra","Andorra la Vella"),
    AGO((short)24,"AO","AGO","Angola","Luanda"),
    ATG((short)28,"AG","ATG","Antigua and Barbuda","St. John's"),
    AZE((short)31,"AZ","AZE","Azerbaijan","Baku"),
    ARG((short)32,"AR","ARG","Argentina","Buenos Aires"),
    AUS((short)36,"AU","AUS","Australia","Canberra"),
    AUT((short)40,"AT","AUT","Austria","Vienna"),
    BHS((short)44,"BS","BHS","Bahamas","Nassau"),
    BHR((short)48,"BH","BHR","Bahrain","Manama"),
    BGD((short)50,"BD","BGD","Bangladesh","Dhaka"),
    ARM((short)51,"AM","ARM","Armenia","Yerevan"),
    BRB((short)52,"BB","BRB","Barbados","Bridgetown"),
    BEL((short)56,"BE","BEL","Belgium","Brussels"),
    BMU((short)60,"BM","BMU","Bermuda","Hamilton"),
    BTN((short)64,"BT","BTN","Bhutan","Thimphu"),
    BOL((short)68,"BO","BOL","Bolivia","La Paz"),
    BIH((short)70,"BA","BIH","Bosnia and Herzegovina","Sarajevo"),
    BWA((short)72,"BW","BWA","Botswana","Gaborone"),
    BVT((short)74,"BV","BVT","Bouvet Island","NOR"),
    BRA((short)76,"BR","BRA","Brazil","Brasilia"),
    BLZ((short)84,"BZ","BLZ","Belize","Belmopan"),
    IOT((short)86,"IO","IOT","British Indian Ocean Territory","Camp Justice"),
    SLB((short)90,"SB","SLB","Solomon Islands","Honiara"),
    VGB((short)92,"VG","VGB","British Virgin Islands","Road Town"),
    BRN((short)96,"BN","BRN","Brunei Daraussalam","Bandar Seri Begawan"),
    BGR((short)100,"BG","BGR","Bulgaria","Sofia"),
    MMR((short)104,"MM","MMR","Myanmar","Rangoon"),
    BDI((short)108,"BI","BDI","Burundi","Bujumbura"),
    BLR((short)112,"BY","BLR","Belarus","Minsk"),
    KHM((short)116,"KH","KHM","Cambodia","Phnom Penh"),
    CMR((short)120,"CM","CMR","Cameroon","Yaoundé"),
    CAN((short)124,"CA","CAN","Canada","Ottawa"),
    CPV((short)132,"CV","CPV","Cape Verde","Praia"),
    CYM((short)136,"KY","CYM","Cayman Islands","George Town"),
    CAF((short)140,"CF","CAF","Central African Republic","Bangui"),
    LKA((short)144,"LK","LKA","Sri Lanka","Colombo"),
    TCD((short)148,"TD","TCD","Chad","N'Djamena"),
    CHL((short)152,"CL","CHL","Chile","Santiago"),
    CHN((short)156,"CN","CHN","China","Beijing"),
    TWN((short)158,"TW","TWN","Taiwan Province of China","Taipei"),
    CXR((short)162,"CX","CXR","Christmas Island","Flying Fish Cove"),
    CCK((short)166,"CC","CCK","Cocos Islands","West Island"),
    COL((short)170,"CO","COL","Colombia","Bogota"),
    COM((short)174,"KM","COM","Comoros","Moroni"),
    MYT((short)175,"YT","MYT","Mayotte","Mamoudzou"),
    COG((short)178,"CG","COG","Congo","Brazzaville"),
    COD((short)180,"CD","COD","The Democratic Republic of the Congo","Kinshasa"),
    COK((short)184,"CK","COK","Cook Islands","Avarua"),
    CRI((short)188,"CR","CRI","Costa Rica","San José"),
    HRV((short)191,"HR","HRV","Croatia","Zagreb"),
    CUB((short)192,"CU","CUB","Cuba","Havana"),
    CYP((short)196,"CY","CYP","Cyprus","Nicosia"),
    CZE((short)203,"CZ","CZE","Czech Republic","Prague"),
    BEN((short)204,"BJ","BEN","Benin","Porto-Novo"),
    DNK((short)208,"DK","DNK","Denmark","Copenhagen"),
    DMA((short)212,"DM","DMA","Dominica","Roseau"),
    DOM((short)214,"DO","DOM","Dominican Republic","Santo Domingo"),
    ECU((short)218,"EC","ECU","Ecuador","Quito"),
    SLV((short)222,"SV","SLV","El Salvador","San Salvador"),
    GNQ((short)226,"GQ","GNQ","Equatorial Guinea","Malabo"),
    ETH((short)230,"ET","ETH","Ethiopia","Addis Ababa"),
    ERI((short)232,"ER","ERI","Eritrea","Asmara"),
    EST((short)233,"EE","EST","Estonia","Tallinn"),
    FRO((short)234,"FO","FRO","Faroe Islands","Tórshavn"),
    FLK((short)238,"FK","FLK","Falkland Islands (Malvinas)","Stanley"),
    SGS((short)239,"GS","SGS","South Georgia And The South Sandwich Islands","King Edward Point"),
    FJI((short)242,"FJ","FJI","Fiji","Suva"),
    FIN((short)246,"FI","FIN","Finland","Helsinki"),
    ALA((short)248,"AX","ALA","Åland Islands","Mariehamn"),
    FRA((short)250,"FR","FRA","France","Paris"),
    GUF((short)254,"GF","GUF","French Guiana","Cayenne"),
    PYF((short)258,"PF","PYF","French Polynesia","Papeete"),
    ATF((short)260,"TF","ATF","French Southern Territories","Saint-Pierre, Réunion"),
    DJI((short)262,"DJ","DJI","Djibouti","Djibouti"),
    GAB((short)266,"GA","GAB","Gabon","Libreville"),
    GEO((short)268,"GE","GEO","Georgia","Tbilisi"),
    GMB((short)270,"GM","GMB","Gambia","Banjul"),
    PSE((short)275,"PS","PSE","Palestine","Jerusalem"),
    DEU((short)276,"DE","DEU","Germany","Berlin"),
    GHA((short)288,"GH","GHA","Ghana","Accra"),
    GIB((short)292,"GI","GIB","Gibraltar","Gibraltar"),
    KIR((short)296,"KI","KIR","Kiribati","Tarawa"),
    GRC((short)300,"GR","GRC","Greece","Athens"),
    GRL((short)304,"GL","GRL","Greenland","Nuuk"),
    GRD((short)308,"GD","GRD","Grenada","St. George's"),
    GLP((short)312,"GP","GLP","Guadeloupe","Basse-Terre"),
    GUM((short)316,"GU","GUM","Guam","Hagåtña"),
    GTM((short)320,"GT","GTM","Guatemala","Guatemala City"),
    GIN((short)324,"GN","GIN","Guinea","Conakry"),
    GUY((short)328,"GY","GUY","Guyana","Georgetown"),
    HTI((short)332,"HT","HTI","Haiti","Port-au-Prince"),
    HMD((short)334,"HM","HMD","Heard Island And McDonald Islands","AUS"),
    VAT((short)336,"VA","VAT","Holy See (Vatican City State)","Vatican City"),
    HND((short)340,"HN","HND","Honduras","Tegucigalpa"),
    HKG((short)344,"HK","HKG","Hong Kong","Hong Kong"),
    HUN((short)348,"HU","HUN","Hungary","Budapest"),
    ISL((short)352,"IS","ISL","Iceland","Reykjavik"),
    IND((short)356,"IN","IND","India","New Delhi"),
    IDN((short)360,"ID","IDN","Indonesia","Jakarta"),
    IRN((short)364,"IR","IRN","Islamic Republic of Iran","Tehran"),
    IRQ((short)368,"IQ","IRQ","Iraq","Baghdad"),
    IRL((short)372,"IE","IRL","Ireland","Dublin"),
    ISR((short)376,"IL","ISR","Israel","Jerusalem"),
    ITA((short)380,"IT","ITA","Italy","Rome"),
    CIV((short)384,"CI","CIV","Cote d'Ivoire","Yamoussoukro"),
    JAM((short)388,"JM","JAM","Jamaica","Kingston"),
    JPN((short)392,"JP","JPN","Japan","Tokyo"),
    KAZ((short)398,"KZ","KAZ","Kazakhstan","Astana"),
    JOR((short)400,"JO","JOR","Jordan","Amman"),
    KEN((short)404,"KE","KEN","Kenya","Nairobi"),
    PRK((short)408,"KP","PRK","Democratic People's Republic of Korea","Pyongyang"),
    KOR((short)410,"KR","KOR","Republic of Korea","Seoul"),
    KWT((short)414,"KW","KWT","Kuwait","Kuwait"),
    KGZ((short)417,"KG","KGZ","Kyrgyzstan","Bishkek"),
    LAO((short)418,"LA","LAO","Lao People's Democratic Republic","Viangchan"),
    LBN((short)422,"LB","LBN","Lebanon","Beirut"),
    LSO((short)426,"LS","LSO","Lesotho","Maseru"),
    LVA((short)428,"LV","LVA","Latvia","Riga"),
    LBR((short)430,"LR","LBR","Liberia","Monrovia"),
    LBY((short)434,"LY","LBY","Libyan Arab Jamahiriya","Tripoli"),
    LIE((short)438,"LI","LIE","Liechtenstein","Vaduz"),
    LTU((short)440,"LT","LTU","Lithuania","Vilnius"),
    LUX((short)442,"LU","LUX","Luxembourg","Luxembourg"),
    MAC((short)446,"MO","MAC","Macao","CHN"),
    MDG((short)450,"MG","MDG","Madagascar","Antananarivo"),
    MWI((short)454,"MW","MWI","Malawi","Lilongwe"),
    MYS((short)458,"MY","MYS","Malaysia","Kuala Lumpur"),
    MDV((short)462,"MV","MDV","Maldives","Malé"),
    MLI((short)466,"ML","MLI","Mali","Bamako"),
    MLT((short)470,"MT","MLT","Malta","Valletta"),
    MTQ((short)474,"MQ","MTQ","Martinique","Fort-de-France"),
    MRT((short)478,"MR","MRT","Mauritania","Nouakchott"),
    MUS((short)480,"MU","MUS","Mauritius","Port Louis"),
    MEX((short)484,"MX","MEX","Mexico","Mexico City"),
    MCO((short)492,"MC","MCO","Monaco","Monaco-ville"),
    MNG((short)496,"MN","MNG","Mongolia","Ulan Bator"),
    MDA((short)498,"MD","MDA","Moldova","Chisinau"),
    MNE((short)499,"ME","MNE","Montenegro","Podgorica"),
    MSR((short)500,"MS","MSR","Montserrat","Plymouth"),
    MAR((short)504,"MA","MAR","Morocco","Rabat"),
    MOZ((short)508,"MZ","MOZ","Mozambique","Maputo"),
    OMN((short)512,"OM","OMN","Oman","Muscat"),
    NAM((short)516,"NA","NAM","Namibia","Windhoek"),
    NRU((short)520,"NR","NRU","Nauru","Yaren"),
    NPL((short)524,"NP","NPL","Nepal","Kathmandu"),
    NLD((short)528,"NL","NLD","Netherlands","Amsterdam; The Hague"),
    //ANT(530,"AN","ANT","Netherlands Antilles","Willemstad"),
    CUW((short)531,"CW","CUW","Curaçao","Willemstad"),
    ABW((short)533,"AW","ABW","Aruba","Oranjestad"),
    SXM((short)534,"SX","SXM","Sint Maarten (Dutch part)","Philipsburg"),
    BES((short)535,"BQ","BES","Bonaire, Sint Eustatius and Saba","Kralendijk"),
    NCL((short)540,"NC","NCL","New Caledonia","Nouméa"),
    VUT((short)548,"VU","VUT","Vanuatu","Port-Vila"),
    NZL((short)554,"NZ","NZL","New Zealand","Wellington"),
    NIC((short)558,"NI","NIC","Nicaragua","Managua"),
    NER((short)562,"NE","NER","Niger","Niamey"),
    NGA((short)566,"NG","NGA","Nigeria","Abuja"),
    NIU((short)570,"NU","NIU","Niue","Alofi"),
    NFK((short)574,"NF","NFK","Norfolk Island","Kingston"),
    NOR((short)578,"NO","NOR","Norway","Oslo"),
    MNP((short)580,"MP","MNP","Northern Mariana Islands","Saipan"),
    UMI((short)581,"UM","UMI","United States Minor Outlying Islands","USA"),
    FSM((short)583,"FM","FSM","Federated States of Micronesia","Palikir"),
    MHL((short)584,"MH","MHL","Marshall Islands","Majuro"),
    PLW((short)585,"PW","PLW","Palau","Koror"),
    PAK((short)586,"PK","PAK","Pakistan","Islamabad"),
    PAN((short)591,"PA","PAN","Panama","Panama City"),
    PNG((short)598,"PG","PNG","Papua New Guinea","Port Moresby"),
    PRY((short)600,"PY","PRY","Paraguay","Asunción"),
    PER((short)604,"PE","PER","Peru","Lima"),
    PHL((short)608,"PH","PHL","Philippines","Manila"),
    PCN((short)612,"PN","PCN","Pitcairn","Adamston"),
    POL((short)616,"PL","POL","Poland","Warsaw"),
    PRT((short)620,"PT","PRT","Portugal","Lisbon"),
    GNB((short)624,"GW","GNB","Guinea-Bissau","Bissau"),
    TLS((short)626,"TL","TLS","Timor-Leste","Dili"),
    PRI((short)630,"PR","PRI","Puerto Rico","San Juan"),
    QAT((short)634,"QA","QAT","Qatar","Doha"),
    REU((short)638,"RE","REU","Réunion","Saint-Denis"),
    ROU((short)642,"RO","ROU","Romania","Bucharest"),
    RUS((short)643,"RU","RUS","Russian Federation","Moscow"),
    RWA((short)646,"RW","RWA","Rwanda","Kigali"),
    BLM((short)652,"BL","BLM","Saint Barthélemy","Gustavia"),
    SHN((short)654,"SH","SHN","Saint Helena","Jamestown"),
    KNA((short)659,"KN","KNA","Saint Kitts and Nevis","Basseterre"),
    AIA((short)660,"AI","AIA","Anguilla","The Valley"),
    LCA((short)662,"LC","LCA","Saint Lucia","Castries"),
    MAF((short)663,"MF","MAF","Saint Martin","Marigot"),
    SPM((short)666,"PM","SPM","Saint Pierre and Miquelon","St.-Pierre"),
    VCT((short)670,"VC","VCT","Saint Vincent and the Grenadines","Kingstown"),
    SMR((short)674,"SM","SMR","San Marino","San Marino"),
    STP((short)678,"ST","STP","São Tomé and Príncipe","São Tomé"),
    SAU((short)682,"SA","SAU","Saudi Arabia","Riyadh"),
    SEN((short)686,"SN","SEN","Senegal","Dakar"),
    SRB((short)688,"RS","SRB","Serbia","Belgrade"),
    SYC((short)690,"SC","SYC","Seychelles","Victoria"),
    SLE((short)694,"SL","SLE","Sierra Leone","Freetown"),
    SGP((short)702,"SG","SGP","Singapore","Singapore City"),
    SVK((short)703,"SK","SVK","Slovakia","Bratislava"),
    VNM((short)704,"VN","VNM","Viet Nam","Hanoi"),
    SVN((short)705,"SI","SVN","Slovenia","Ljubljana"),
    SOM((short)706,"SO","SOM","Somalia","Mogadishu"),
    ZAF((short)710,"ZA","ZAF","South Africa","Pretoria (administrative) Cape Town (legislative)"),
    ZWE((short)716,"ZW","ZWE","Zimbabwe","Harare"),
    ESP((short)724,"ES","ESP","Spain","Madrid"),
    SSD((short)728,"SS","SSD","South Sudan","Juba"),
    ESH((short)732,"EH","ESH","Western Sahara","Laayoune"),
    SDN((short)736,"SD","SDN","Sudan","Khartoum"),
    SUR((short)740,"SR","SUR","Suriname","Paramaribo"),
    SJM((short)744,"SJ","SJM","Svalbard and Jan Mayen Islands","Longyearbyen"),
    SWZ((short)748,"SZ","SWZ","Swaziland","Mbabane"),
    SWE((short)752,"SE","SWE","Sweden","Stockholm"),
    CHE((short)756,"CH","CHE","Switzerland","Bern"),
    SYR((short)760,"SY","SYR","Syrian Arab Republic","Damascus"),
    TJK((short)762,"TJ","TJK","Tajikistan","Dushanbe"),
    THA((short)764,"TH","THA","Thailand","Bangkok"),
    TGO((short)768,"TG","TGO","Togo","Lomé"),
    TKL((short)772,"TK","TKL","Tokelau","Atafu"),
    TON((short)776,"TO","TON","Tonga","Nuku'alofa"),
    TTO((short)780,"TT","TTO","Trinidad and Tobago","Port-of-Spain"),
    ARE((short)784,"AE","ARE","United Arab Emirates","Abu Dhabi"),
    TUN((short)788,"TN","TUN","Tunisia","Tunis"),
    TUR((short)792,"TR","TUR","Turkey","Ankara"),
    TKM((short)795,"TM","TKM","Turkmenistan","Ashgabat"),
    TCA((short)796,"TC","TCA","Turks and Caicos Islands","Cockburn Town"),
    TUV((short)798,"TV","TUV","Tuvalu","Funafuti"),
    UGA((short)800,"UG","UGA","Uganda","Kampala"),
    UKR((short)804,"UA","UKR","Ukraine","Kiev"),
    MKD((short)807,"MK","MKD","The former Yugoslav Republic of Macedonia","Skopje"),
    EGY((short)818,"EG","EGY","Egypt","Cairo"),
    GBR((short)826,"GB","GBR","United Kingdom","London"),
    GGY((short)831,"GG","GGY","Guernsey","Saint Peter Port"),
    JEY((short)832,"JE","JEY","Jersey","Saint Helier"),
    IMN((short)833,"IM","IMN","Isle Of Man","Douglas"),
    TZA((short)834,"TZ","TZA","United Republic of Tanzania","Dodoma"),
    USA((short)840,"US","USA","United States","Washington D.C."),
    VIR((short)850,"VI","VIR","U. S. Virgin Islands","Charlotte Amalie"),
    BFA((short)854,"BF","BFA","Burkina Faso","Ouagadougou"),
    URY((short)858,"UY","URY","Uruguay","Montevideo"),
    UZB((short)860,"UZ","UZB","Uzbekistan","Tashkent"),
    VEN((short)862,"VE","VEN","Venezuela","Caracas"),
    WLF((short)876,"WF","WLF","Wallis and Futuna Islands","Mata-Utu"),
    WSM((short)882,"WS","WSM","Samoa","Apia"),
    YEM((short)887,"YE","YEM","Yemen","Sanaa"),
    ZMB((short)894,"ZM","ZMB","Zambia","Lusaka");

    private static final String NEWLINE = System.getProperty("line.separator");
    private final short    code;       // the United Nations Statistics Division (UNSD) 3-digit code number
    private final String iso2Code;   // the International Standards Organization (ISO) 2-digit alphabetic code
    private final String iso3Code;   // the International Standards Organization (ISO) 3-digit alphabetic code
    private final String name;       // name of country
    private final String capital;    // name of capital

    Country(short code, String iso2Code, String iso3Code, String name, String capital) {
        this.code    = code;
        this.iso2Code = iso2Code;
        this.iso3Code = iso3Code;
        this.name    = name;
        this.capital = capital;
    }


    public short getCode() {
        return code;
    }

    public String getIso2Code() {
        return iso2Code;
    }

    public String getIso3Code() {
        return iso3Code;
    }

    public String getName() {
        return name;
    }

    public String getName(Locale locale){
        return new Locale("",iso2Code).getDisplayName(locale);
    }

    public String getCapital() {
        return capital;
    }

    public Set<Locale> getLocales(){
        return Arrays.stream(Locale.getAvailableLocales()).filter(l -> {
            try {
                return l.getISO3Country().equals(iso3Code);
            }catch (MissingResourceException e){
                return false;
            }
        }).collect(Collectors.toUnmodifiableSet());
    }

    public String getCurrencyCode() {
        return getCurrency().getCurrencyCode();
    }

    public String getCurrencySymbol() {
        return getCurrency().getSymbol();
    }

    public Currency getCurrency(){
        return Currency.getInstance(new Locale("", iso2Code));
    }

    public String flagEmoji(){
        StringBuilder emojiStr = new StringBuilder();
        for (int i = 0; i < iso2Code.length(); i++) {
            emojiStr.appendCodePoint(iso2Code.charAt(i) + 127397);
        }
        return emojiStr.toString();
    }

    public String toString() {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for(Locale locale:this.getLocales()){
            jsonArrayBuilder.add(Json.createObjectBuilder()
                    .add("tag",locale.toLanguageTag())
                    .add("name",locale.getLanguage())
                    .add("lang",locale.getDisplayLanguage(locale))
                    .add("country",locale.getDisplayCountry(locale)).build());
        }
        return  Json.createObjectBuilder()
                .add("countryCode",code)
                .add("name",name)
                .add("capital",capital)
                .add("iso2",iso2Code)
                .add("iso3",iso3Code)
                .add("currencyCode",getCurrencyCode())
                .add("currencySymbol",getCurrencySymbol())
                .add("flagEmoji",flagEmoji())
                .add("languages",jsonArrayBuilder.build())
                .build().toString();
    }
}
