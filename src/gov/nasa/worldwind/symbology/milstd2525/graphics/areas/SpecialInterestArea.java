/*
 * Copyright 2006-2009, 2017, 2020 United States Government, as represented by the
 * Administrator of the National Aeronautics and Space Administration.
 * All rights reserved.
 * 
 * The NASA World Wind Java (WWJ) platform is licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * NASA World Wind Java (WWJ) also contains the following 3rd party Open Source
 * software:
 * 
 *     Jackson Parser – Licensed under Apache 2.0
 *     GDAL – Licensed under MIT
 *     JOGL – Licensed under  Berkeley Software Distribution (BSD)
 *     Gluegen – Licensed under Berkeley Software Distribution (BSD)
 * 
 * A complete listing of 3rd Party software notices and licenses included in
 * NASA World Wind Java (WWJ)  can be found in the WorldWindJava-v2.2 3rd-party
 * notices and licenses PDF found in code directory.
 */

package gov.nasa.worldwind.symbology.milstd2525.graphics.areas;

import gov.nasa.worldwind.symbology.milstd2525.graphics.TacGrpSidc;

import java.util.*;

/**
 * Implementation of General Command/Special area graphics. This class implements the following graphics:
 * <ul> <li>Area of Operations (2.X.2.6.2.1)</li> <li>Named Area of Interest (2.X.2.6.2.4)</li> <li>Targeted Area of
 * Interest (2.X.2.6.2.5)</li> </ul>
 *
 * @author pabercrombie
 * @version $Id: SpecialInterestArea.java 1171 2013-02-11 21:45:02Z dcollins $
 */
public class SpecialInterestArea extends BasicArea
{
    /**
     * Indicates the graphics supported by this class.
     *
     * @return List of masked SIDC strings that identify graphics that this class supports.
     */
    public static List<String> getSupportedGraphics()
    {
        return Arrays.asList(
            TacGrpSidc.C2GM_SPL_ARA_AOO,
            TacGrpSidc.C2GM_SPL_ARA_NAI,
            TacGrpSidc.C2GM_SPL_ARA_TAI);
    }

    /**
     * Create a new area graphic.
     *
     * @param sidc Symbol code the identifies the graphic.
     */
    public SpecialInterestArea(String sidc)
    {
        super(sidc);
        this.setShowHostileIndicator(false);
    }

    @Override
    protected String getGraphicLabel()
    {
        String code = this.maskedSymbolCode;

        if (TacGrpSidc.C2GM_SPL_ARA_AOO.equalsIgnoreCase(code))
            return "AO";
        else if (TacGrpSidc.C2GM_SPL_ARA_NAI.equalsIgnoreCase(code))
            return "NAI";
        else if (TacGrpSidc.C2GM_SPL_ARA_TAI.equalsIgnoreCase(code))
            return "TAI";

        return "";
    }
}