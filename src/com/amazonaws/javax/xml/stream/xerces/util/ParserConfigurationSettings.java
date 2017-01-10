package com.amazonaws.javax.xml.stream.xerces.util;

import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponentManager;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLConfigurationException;
import java.util.Hashtable;
import java.util.Vector;

public class ParserConfigurationSettings implements XMLComponentManager {
    static int counter;
    protected Hashtable fFeatures;
    protected XMLComponentManager fParentSettings;
    protected Hashtable fProperties;
    protected Vector fRecognizedFeatures;
    protected Vector fRecognizedProperties;

    public ParserConfigurationSettings() {
        this(null);
    }

    public ParserConfigurationSettings(XMLComponentManager parent) {
        this.fRecognizedFeatures = new Vector();
        this.fRecognizedProperties = new Vector();
        this.fFeatures = new Hashtable();
        this.fProperties = new Hashtable();
        this.fParentSettings = parent;
    }

    public void addRecognizedFeatures(String[] featureIds) {
        int featureIdsCount = featureIds != null ? featureIds.length : 0;
        for (int i = 0; i < featureIdsCount; i++) {
            String featureId = featureIds[i];
            if (!this.fRecognizedFeatures.contains(featureId)) {
                this.fRecognizedFeatures.addElement(featureId);
            }
        }
    }

    static {
        counter = 1;
    }

    public void setFeature(String featureId, boolean state) throws XMLConfigurationException {
        checkFeature(featureId);
        this.fFeatures.put(featureId, state ? Boolean.TRUE : Boolean.FALSE);
    }

    public void addRecognizedProperties(String[] propertyIds) {
        int propertyIdsCount = propertyIds != null ? propertyIds.length : 0;
        for (int i = 0; i < propertyIdsCount; i++) {
            String propertyId = propertyIds[i];
            if (!this.fRecognizedProperties.contains(propertyId)) {
                this.fRecognizedProperties.addElement(propertyId);
            }
        }
    }

    public void setProperty(String propertyId, Object value) throws XMLConfigurationException {
        checkProperty(propertyId);
        this.fProperties.put(propertyId, value);
    }

    public boolean getFeature(String featureId) throws XMLConfigurationException {
        Boolean state = (Boolean) this.fFeatures.get(featureId);
        if (state != null) {
            return state.booleanValue();
        }
        checkFeature(featureId);
        return false;
    }

    public Object getProperty(String propertyId) throws XMLConfigurationException {
        Object propertyValue = this.fProperties.get(propertyId);
        if (propertyValue == null) {
            checkProperty(propertyId);
        }
        return propertyValue;
    }

    protected void checkFeature(String featureId) throws XMLConfigurationException {
        if (!this.fRecognizedFeatures.contains(featureId)) {
            if (this.fParentSettings != null) {
                this.fParentSettings.getFeature(featureId);
                return;
            }
            throw new XMLConfigurationException((short) 0, featureId);
        }
    }

    protected void checkProperty(String propertyId) throws XMLConfigurationException {
        if (!this.fRecognizedProperties.contains(propertyId)) {
            if (this.fParentSettings != null) {
                this.fParentSettings.getProperty(propertyId);
                return;
            }
            throw new XMLConfigurationException((short) 0, propertyId);
        }
    }
}
