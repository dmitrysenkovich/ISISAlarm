package com.bottles.five.isisalarm.web;

import android.view.MenuItem;
import android.webkit.WebView;

import com.bottles.five.isisalarm.R;

public class WebUtils {
    private final static String WIKIPEDIA_URL = "http://en.wikipedia.org/wiki/";

    public static void loadTerroristPage(MenuItem item, WebView webView) {
        int id = item.getItemId();
        if (id == R.id.abu_ala_al_afri || id == R.id.abu_ali_al_anbari ||
                id == R.id.abu_ayman_al_iraqi || id == R.id.abu_ayyub_al_masri ||
                id == R.id.abu_bakr_al_baghdadi || id == R.id.abu_mohammad_al_adnani ||
                id == R.id.abu_mohammad_al_julani || id == R.id.abu_musab_al_zarqawi ||
                id == R.id.abu_omar_al_baghdadi || id == R.id.abu_omar_al_shishani ||
                id == R.id.abu_suleiman_al_naser) {
            String terroristName = item.getTitle().toString();
            String terroristPage = WIKIPEDIA_URL + terroristName.replace(" ", "_");
            webView.loadUrl(terroristPage);
        }
    }
}
