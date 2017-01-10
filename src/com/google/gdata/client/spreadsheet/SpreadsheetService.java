package com.google.gdata.client.spreadsheet;

import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.google.gdata.client.AuthTokenFactory;
import com.google.gdata.client.GoogleService;
import com.google.gdata.client.Service;
import com.google.gdata.client.Service.GDataRequestFactory;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.RecordFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.TableFeed;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.Version;
import com.google.gdata.util.VersionRegistry;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class SpreadsheetService extends GoogleService {
    public static final Version DEFAULT_VERSION;
    public static final String SPREADSHEET_SERVICE = "wise";
    public static final String SPREADSHEET_SERVICE_VERSION;

    public static final class Versions {
        public static final Version V1;
        public static final Version V2;
        public static final Version V3;

        static {
            V1 = new Version(SpreadsheetService.class, XMLStreamWriterImpl.DEFAULT_XML_VERSION, com.google.gdata.client.Service.Versions.V1);
            V2 = new Version(SpreadsheetService.class, "2.0", com.google.gdata.client.Service.Versions.V2);
            V3 = new Version(SpreadsheetService.class, "3.0", com.google.gdata.client.Service.Versions.V2);
        }

        private Versions() {
        }
    }

    static {
        SPREADSHEET_SERVICE_VERSION = "GSpread-Java/" + SpreadsheetService.class.getPackage().getImplementationVersion();
        DEFAULT_VERSION = Service.initServiceVersion(SpreadsheetService.class, Versions.V3);
    }

    public SpreadsheetService(String applicationName) {
        super(SPREADSHEET_SERVICE, applicationName);
        declareExtensions();
    }

    public SpreadsheetService(String applicationName, GDataRequestFactory requestFactory, AuthTokenFactory authTokenFactory) {
        super(applicationName, requestFactory, authTokenFactory);
        declareExtensions();
    }

    public SpreadsheetService(String applicationName, String protocol, String domainName) {
        super(SPREADSHEET_SERVICE, applicationName, protocol, domainName);
        declareExtensions();
    }

    public String getServiceVersion() {
        return SPREADSHEET_SERVICE_VERSION + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + super.getServiceVersion();
    }

    public static Version getVersion() {
        return VersionRegistry.get().getVersion(SpreadsheetService.class);
    }

    private void declareExtensions() {
        new CellFeed().declareExtensions(this.extProfile);
        new ListFeed().declareExtensions(this.extProfile);
        new RecordFeed().declareExtensions(this.extProfile);
        new SpreadsheetFeed().declareExtensions(this.extProfile);
        new TableFeed().declareExtensions(this.extProfile);
        new WorksheetFeed().declareExtensions(this.extProfile);
    }
}
