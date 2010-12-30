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

package com.googlecode.charts4j.example;

import static com.googlecode.charts4j.example.Color.*;
import static com.googlecode.charts4j.example.USAState.Code.*;
import static com.googlecode.charts4j.example.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class MapChartExample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.ALL);
    }

    @Test
    public void example1() {
        // EXAMPLE CODE START
        MapChart chart = GCharts.newMapChart(GeographicalArea.USA);

        PoliticalBoundary al = new USAState( AL, 10);
        PoliticalBoundary ak = new USAState( AK, 10);
        PoliticalBoundary az = new USAState( AZ, 10);
        PoliticalBoundary ar = new USAState( AR, 10);
        PoliticalBoundary ca = new USAState( CA, 90);
        PoliticalBoundary co = new USAState( CO, 50);
        PoliticalBoundary ct = new USAState( CT, 90);
        PoliticalBoundary de = new USAState( DE, 90);
        PoliticalBoundary fl = new USAState( FL, 50);
        PoliticalBoundary ga = new USAState( GA, 10);
        PoliticalBoundary hi = new USAState( HI, 90);
        PoliticalBoundary id = new USAState( ID, 10);
        PoliticalBoundary il = new USAState( IL, 90);
        PoliticalBoundary in = new USAState( IN, 50);
        PoliticalBoundary ia = new USAState( IA, 50);
        PoliticalBoundary ks = new USAState( KS, 10);
        PoliticalBoundary ky = new USAState( KY, 10);
        PoliticalBoundary la = new USAState( LA, 10);
        PoliticalBoundary me = new USAState( ME, 50);
        PoliticalBoundary md = new USAState( MD, 90);
        PoliticalBoundary ma = new USAState( MA, 90);
        PoliticalBoundary mi = new USAState( MI, 90);
        PoliticalBoundary mn = new USAState( MN, 90);
        PoliticalBoundary ms = new USAState( MS, 10);
        PoliticalBoundary mo = new USAState( MO, 10);
        PoliticalBoundary mt = new USAState( MT, 90);
        PoliticalBoundary ne = new USAState( NE, 10);
        PoliticalBoundary nv = new USAState( NV, 90);
        PoliticalBoundary nh = new USAState( NH, 90);
        PoliticalBoundary nj = new USAState( NJ, 90);
        PoliticalBoundary nm = new USAState( NM, 50);
        PoliticalBoundary ny = new USAState( NY, 90);
        PoliticalBoundary nc = new USAState( NC, 50);
        PoliticalBoundary nd = new USAState( ND, 90);
        PoliticalBoundary oh = new USAState( OH, 90);
        PoliticalBoundary ok = new USAState( OK, 10);
        PoliticalBoundary or = new USAState( OR, 90);
        PoliticalBoundary pa = new USAState( PA, 50);
        PoliticalBoundary ri = new USAState( RI, 90);
        PoliticalBoundary sc = new USAState( SC, 50);
        PoliticalBoundary sd = new USAState( SD, 10);
        PoliticalBoundary tn = new USAState( TN, 10);
        PoliticalBoundary tx = new USAState( TX, 10);
        PoliticalBoundary ut = new USAState( UT, 10);
        PoliticalBoundary vt = new USAState( VT, 90);
        PoliticalBoundary va = new USAState( VA, 50);
        PoliticalBoundary wa = new USAState( WA, 90);
        PoliticalBoundary wv = new USAState( WV, 10);
        PoliticalBoundary wi = new USAState( WI, 90);
        PoliticalBoundary wy = new USAState( WY, 10);

        chart.addPoliticalBoundaries(al,ak,az,ar,ca,co,ct,de,fl,ga,hi,id,il,in,ia,ks,ky,la,me,md,ma,mi,mn,ms,mo,mt,ne,nv,nh,nj,nm,ny,nc,nd,oh,ok,or,pa,ri,sc,sd,tn,tx,ut,vt,va,wa,wv,wi,wy);
        chart.setColorGradient(WHITE, RED, BLUE);
        chart.setBackgroundFill(Fills.newSolidFill(ALICEBLUE));
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.

        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(url);
        String expectedString = "http://chart.apis.google.com/chart?chf=bg,s,F0F8FF&chs=440x220&chd=e:GaGaGaGa5mgA5m5mgAGa5mGa5mgAgAGaGaGagA5m5m5m5mGaGa5mGa5m5m5mgA5mgA5m5mGa5mgA5mgAGaGaGaGa5mgA5mGa5mGa&chtm=usa&chco=FFFFFF,FF0000,0000FF&chld=ALAKAZARCACOCTDEFLGAHIIDILINIAKSKYLAMEMDMAMIMNMSMOMTNENVNHNJNMNYNCNDOHOKORPARISCSDTNTXUTVTVAWAWVWIWY&cht=t";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }
}
