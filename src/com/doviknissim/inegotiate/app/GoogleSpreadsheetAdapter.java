package com.doviknissim.inegotiate.app;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.api.client.googleapis.GoogleTransport;
import com.google.api.client.googleapis.auth.clientlogin.ClientLogin;
import com.google.api.client.googleapis.auth.clientlogin.ClientLogin.Response;
import com.google.api.client.googleapis.json.JsonCParser;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GoogleSpreadsheetAdapter {
    private String CLIENT_LOGIN_PASSWORD;
    private String CLIENT_LOGIN_SPREADSHEET_SERVICE;
    private String CLIENT_LOGIN_USERNAME;
    private String DEAL_TRACKING_SPREADSHEET;
    private String DOWNLOADS_TRACKING_SPREADSHEET;
    private SharedPreferences prefs;
    private Map row;

    public class UpdateDownloadSpreadsheetTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... unused) {
            HttpTransport transport = GoogleTransport.create();
            transport.addParser(new JsonCParser());
            try {
                ClientLogin authenticator = new ClientLogin();
                authenticator.authTokenType = GoogleSpreadsheetAdapter.this.CLIENT_LOGIN_SPREADSHEET_SERVICE;
                authenticator.username = GoogleSpreadsheetAdapter.this.CLIENT_LOGIN_USERNAME;
                authenticator.password = GoogleSpreadsheetAdapter.this.CLIENT_LOGIN_PASSWORD;
                Response response = authenticator.authenticate();
                response.setAuthorizationHeader(transport);
                String str = "INEGOTIATE_GOOGLE_AUTH_TOKEN";
                GoogleSpreadsheetAdapter.this.prefs.edit().putString(r33, response.auth);
            } catch (HttpResponseException e) {
                try {
                    Log.e("iNegotiate", "[ERROR] Failed to authenticate with Google Client Login. the following exception was thrown " + e.response.parseAsString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (IOException e2) {
                Log.e("iNegotiate", "[ERROR] Failed to authenticate with Google Client Login. the following exception was thrown " + e2.getMessage());
            }
            try {
                int i;
                SpreadsheetService spreadsheetService = new SpreadsheetService("MySpreadsheetIntegration-v1");
                spreadsheetService.setUserCredentials(GoogleSpreadsheetAdapter.this.CLIENT_LOGIN_USERNAME, GoogleSpreadsheetAdapter.this.CLIENT_LOGIN_PASSWORD);
                List<SpreadsheetEntry> spreadsheets = ((SpreadsheetFeed) spreadsheetService.getFeed(new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full"), SpreadsheetFeed.class)).getEntries();
                SpreadsheetEntry downloadsTrackingSpreadsheetEntry = null;
                for (i = 0; i < spreadsheets.size(); i++) {
                    SpreadsheetEntry entry = (SpreadsheetEntry) spreadsheets.get(i);
                    if (entry.getTitle().getPlainText().equalsIgnoreCase(GoogleSpreadsheetAdapter.this.DOWNLOADS_TRACKING_SPREADSHEET)) {
                        downloadsTrackingSpreadsheetEntry = entry;
                        break;
                    }
                }
                if (downloadsTrackingSpreadsheetEntry == null) {
                    Log.e("iNegotiate", "[ERROR] Did not find the inegotiate_downloads_tracking spreadsheet");
                    return null;
                }
                List<WorksheetEntry> worksheets = downloadsTrackingSpreadsheetEntry.getWorksheets();
                for (i = 0; i < worksheets.size(); i++) {
                    WorksheetEntry worksheet = (WorksheetEntry) worksheets.get(i);
                    if (worksheet.getTitle().getPlainText().equals("raw")) {
                        String osVersion = VERSION.RELEASE;
                        String osApiLevel = VERSION.SDK;
                        String device = Build.DEVICE;
                        String model = Build.MODEL;
                        String manufacturer = Build.MANUFACTURER;
                        String downloads = "1";
                        Date time = Calendar.getInstance().getTime();
                        String formattedDate = new SimpleDateFormat("MMM-dd-yyyy").format(r33);
                        Locale locale = Locale.getDefault();
                        String deviceLanguage = StringUtil.EMPTY_STRING;
                        if (locale != null) {
                            deviceLanguage = locale.getDisplayLanguage();
                        }
                        URL listFeedUrl = worksheet.getListFeedUrl();
                        ListEntry newDownload = new ListEntry();
                        newDownload.getCustomElements().setValueLocal(DBAdapter.DATE, formattedDate);
                        newDownload.getCustomElements().setValueLocal("downloads", downloads);
                        newDownload.getCustomElements().setValueLocal("androidversion", osVersion);
                        newDownload.getCustomElements().setValueLocal("androidapilevel", osApiLevel);
                        newDownload.getCustomElements().setValueLocal("device", device);
                        newDownload.getCustomElements().setValueLocal("model", model);
                        newDownload.getCustomElements().setValueLocal("manufacturer", manufacturer);
                        newDownload.getCustomElements().setValueLocal("language", deviceLanguage);
                        ListEntry listEntry = (ListEntry) spreadsheetService.insert(listFeedUrl, newDownload);
                    }
                }
                return null;
            } catch (IOException e22) {
                Log.e("iNegotiate", "[ERROR] Failed to authenticate with Google Client Login. the following IO Exception was thrown " + e22.getMessage());
            } catch (ServiceException e3) {
                Log.e("iNegotiate", "[ERROR] Failed to authenticate with Google Client Login. the following Service Exception was thrown " + e3.getMessage());
            }
        }
    }

    public class UpdateMasterSpreadsheetTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... unused) {
            HttpTransport transport = GoogleTransport.create();
            transport.addParser(new JsonCParser());
            try {
                ClientLogin authenticator = new ClientLogin();
                authenticator.authTokenType = GoogleSpreadsheetAdapter.this.CLIENT_LOGIN_SPREADSHEET_SERVICE;
                authenticator.username = GoogleSpreadsheetAdapter.this.CLIENT_LOGIN_USERNAME;
                authenticator.password = GoogleSpreadsheetAdapter.this.CLIENT_LOGIN_PASSWORD;
                Response response = authenticator.authenticate();
                response.setAuthorizationHeader(transport);
                String str = "INEGOTIATE_GOOGLE_AUTH_TOKEN";
                GoogleSpreadsheetAdapter.this.prefs.edit().putString(r23, response.auth);
            } catch (HttpResponseException e) {
                try {
                    Log.e("iNegotiate", "[ERROR] Failed to authenticate with Google Client Login. the following exception was thrown " + e.response.parseAsString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (IOException e2) {
                Log.e("iNegotiate", "[ERROR] Failed to authenticate with Google Client Login. the following exception was thrown " + e2.getMessage());
            }
            try {
                int i;
                SpreadsheetService myservice = new SpreadsheetService("MySpreadsheetIntegration-v1");
                myservice.setUserCredentials(GoogleSpreadsheetAdapter.this.CLIENT_LOGIN_USERNAME, GoogleSpreadsheetAdapter.this.CLIENT_LOGIN_PASSWORD);
                Class cls = SpreadsheetFeed.class;
                List<SpreadsheetEntry> spreadsheets = ((SpreadsheetFeed) myservice.getFeed(new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full"), r23)).getEntries();
                SpreadsheetEntry dealTrackingSpreadsheetEntry = null;
                for (i = 0; i < spreadsheets.size(); i++) {
                    SpreadsheetEntry entry = (SpreadsheetEntry) spreadsheets.get(i);
                    if (entry.getTitle().getPlainText().equalsIgnoreCase(GoogleSpreadsheetAdapter.this.DEAL_TRACKING_SPREADSHEET)) {
                        dealTrackingSpreadsheetEntry = entry;
                        break;
                    }
                }
                if (dealTrackingSpreadsheetEntry == null) {
                    Log.e("iNegotiate", "[ERROR] Did not find the inegotiate_deals_tracking spreadsheet");
                    return null;
                }
                List<WorksheetEntry> worksheets = dealTrackingSpreadsheetEntry.getWorksheets();
                for (i = 0; i < worksheets.size(); i++) {
                    WorksheetEntry worksheet = (WorksheetEntry) worksheets.get(i);
                    if (worksheet.getTitle().getPlainText().equals("raw")) {
                        URL listFeedUrl = worksheet.getListFeedUrl();
                        String dealID = new StringBuilder(String.valueOf((String) GoogleSpreadsheetAdapter.this.row.get("user1bucket"))).append("-").append((String) GoogleSpreadsheetAdapter.this.row.get("user2bucket")).toString();
                        ListEntry newDeal = new ListEntry();
                        newDeal.getCustomElements().setValueLocal("id", dealID);
                        newDeal.getCustomElements().setValueLocal("product", (String) GoogleSpreadsheetAdapter.this.row.get("product"));
                        newDeal.getCustomElements().setValueLocal("amount", (String) GoogleSpreadsheetAdapter.this.row.get("amount"));
                        newDeal.getCustomElements().setValueLocal("currency", (String) GoogleSpreadsheetAdapter.this.row.get("currency"));
                        newDeal.getCustomElements().setValueLocal(DBAdapter.DATE, (String) GoogleSpreadsheetAdapter.this.row.get(DBAdapter.DATE));
                        newDeal.getCustomElements().setValueLocal("image", (String) GoogleSpreadsheetAdapter.this.row.get("image"));
                        newDeal.getCustomElements().setValueLocal("user1bucket", (String) GoogleSpreadsheetAdapter.this.row.get("user1bucket"));
                        newDeal.getCustomElements().setValueLocal("user1name", (String) GoogleSpreadsheetAdapter.this.row.get("user1name"));
                        newDeal.getCustomElements().setValueLocal("user1email", (String) GoogleSpreadsheetAdapter.this.row.get("user1email"));
                        newDeal.getCustomElements().setValueLocal("user1cell", (String) GoogleSpreadsheetAdapter.this.row.get("user1cell"));
                        newDeal.getCustomElements().setValueLocal("user1buyerseller", (String) GoogleSpreadsheetAdapter.this.row.get("user1buyerseller"));
                        newDeal.getCustomElements().setValueLocal("user2bucket", (String) GoogleSpreadsheetAdapter.this.row.get("user2bucket"));
                        newDeal.getCustomElements().setValueLocal("user2name", (String) GoogleSpreadsheetAdapter.this.row.get("user2name"));
                        newDeal.getCustomElements().setValueLocal("user2email", (String) GoogleSpreadsheetAdapter.this.row.get("user2email"));
                        newDeal.getCustomElements().setValueLocal("user2cell", (String) GoogleSpreadsheetAdapter.this.row.get("user2cell"));
                        newDeal.getCustomElements().setValueLocal("user2buyerseller", (String) GoogleSpreadsheetAdapter.this.row.get("user2buyerseller"));
                        newDeal.getCustomElements().setValueLocal("cut", (String) GoogleSpreadsheetAdapter.this.row.get("cut"));
                        ListEntry listEntry = (ListEntry) myservice.insert(listFeedUrl, newDeal);
                    }
                }
                return null;
            } catch (IOException e22) {
                Log.e("iNegotiate", "[ERROR] Failed to authenticate with Google Client Login. the following IO Exception was thrown " + e22.getMessage());
            } catch (ServiceException e3) {
                Log.e("iNegotiate", "[ERROR] Failed to authenticate with Google Client Login. the following Service Exception was thrown " + e3.getMessage());
            }
        }
    }

    public GoogleSpreadsheetAdapter(Map row, SharedPreferences prefs) {
        this.CLIENT_LOGIN_SPREADSHEET_SERVICE = "https://docs.google.com/feeds";
        this.CLIENT_LOGIN_USERNAME = "inegotiatedevteam@gmail.com";
        this.CLIENT_LOGIN_PASSWORD = "idtidtidt";
        this.DEAL_TRACKING_SPREADSHEET = "inegotiate_deals_tracking";
        this.DOWNLOADS_TRACKING_SPREADSHEET = "inegotiate_downloads_tracking";
        this.row = null;
        this.prefs = null;
        this.row = row;
        this.prefs = prefs;
    }

    public GoogleSpreadsheetAdapter(SharedPreferences prefs) {
        this.CLIENT_LOGIN_SPREADSHEET_SERVICE = "https://docs.google.com/feeds";
        this.CLIENT_LOGIN_USERNAME = "inegotiatedevteam@gmail.com";
        this.CLIENT_LOGIN_PASSWORD = "idtidtidt";
        this.DEAL_TRACKING_SPREADSHEET = "inegotiate_deals_tracking";
        this.DOWNLOADS_TRACKING_SPREADSHEET = "inegotiate_downloads_tracking";
        this.row = null;
        this.prefs = null;
        this.row = null;
        this.prefs = prefs;
    }

    public Map getRow() {
        return this.row;
    }

    public void setRow(Map row) {
        this.row = row;
    }

    public SharedPreferences getPrefs() {
        return this.prefs;
    }

    public void setPrefs(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public void updateMasterSpreadsheet() {
        new UpdateMasterSpreadsheetTask().execute(new Void[0]);
    }

    public void updateDownloadInformation() {
        new UpdateDownloadSpreadsheetTask().execute(new Void[0]);
    }
}
