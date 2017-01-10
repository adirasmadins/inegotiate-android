package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.google.gdata.util.common.base.StringUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Date;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XpathUtils {
    private static DateUtils dateUtils;
    private static DocumentBuilderFactory factory;
    private static Log log;

    static {
        dateUtils = new DateUtils();
        log = LogFactory.getLog(XpathUtils.class);
        factory = DocumentBuilderFactory.newInstance();
    }

    public static Boolean asBoolean(String str, Node node) throws XPathExpressionException {
        String evaluateAsString = evaluateAsString(str, node);
        return isEmptyString(evaluateAsString) ? null : Boolean.valueOf(evaluateAsString);
    }

    public static Byte asByte(String str, Node node) throws XPathExpressionException {
        String evaluateAsString = evaluateAsString(str, node);
        return isEmptyString(evaluateAsString) ? null : Byte.valueOf(evaluateAsString);
    }

    public static ByteBuffer asByteBuffer(String str, Node node) throws XPathExpressionException {
        ByteBuffer byteBuffer = null;
        String evaluateAsString = evaluateAsString(str, node);
        if (!(isEmptyString(evaluateAsString) || isEmpty(node))) {
            try {
                byteBuffer = ByteBuffer.wrap(Base64.decodeBase64(evaluateAsString.getBytes(StringEncodings.UTF8)));
            } catch (Throwable e) {
                throw new AmazonClientException("Unable to unmarshall XML data into a ByteBuffer", e);
            }
        }
        return byteBuffer;
    }

    public static Date asDate(String str, Node node) throws XPathExpressionException {
        Date date = null;
        String evaluateAsString = evaluateAsString(str, node);
        if (!isEmptyString(evaluateAsString)) {
            try {
                date = dateUtils.parseIso8601Date(evaluateAsString);
            } catch (Throwable e) {
                log.error("Unable to parse date '" + evaluateAsString + "':  " + e.getMessage(), e);
            }
        }
        return date;
    }

    public static Double asDouble(String str, Node node) throws XPathExpressionException {
        String evaluateAsString = evaluateAsString(str, node);
        return isEmptyString(evaluateAsString) ? null : Double.valueOf(evaluateAsString);
    }

    public static Float asFloat(String str, Node node) throws XPathExpressionException {
        String evaluateAsString = evaluateAsString(str, node);
        return isEmptyString(evaluateAsString) ? null : Float.valueOf(evaluateAsString);
    }

    public static Integer asInteger(String str, Node node) throws XPathExpressionException {
        String evaluateAsString = evaluateAsString(str, node);
        return isEmptyString(evaluateAsString) ? null : Integer.valueOf(evaluateAsString);
    }

    public static Long asLong(String str, Node node) throws XPathExpressionException {
        String evaluateAsString = evaluateAsString(str, node);
        return isEmptyString(evaluateAsString) ? null : Long.valueOf(evaluateAsString);
    }

    public static Node asNode(String str, Node node) throws XPathExpressionException {
        return node == null ? null : findXPathNode(node, str);
    }

    public static NodeList asNodeList(String str, Node node) throws XPathExpressionException {
        return node == null ? null : findXPathNodeList(node, str);
    }

    public static String asString(String str, Node node) throws XPathExpressionException {
        return evaluateAsString(str, node);
    }

    public static Document documentFrom(InputStream inputStream) throws SAXException, IOException, ParserConfigurationException {
        InputStream namespaceRemovingInputStream = new NamespaceRemovingInputStream(inputStream);
        Document parse = factory.newDocumentBuilder().parse(namespaceRemovingInputStream);
        namespaceRemovingInputStream.close();
        return parse;
    }

    public static Document documentFrom(String str) throws SAXException, IOException, ParserConfigurationException {
        return documentFrom(new ByteArrayInputStream(str.getBytes()));
    }

    public static Document documentFrom(URL url) throws SAXException, IOException, ParserConfigurationException {
        return documentFrom(url.openStream());
    }

    private static String evaluateAsString(String str, Node node) throws XPathExpressionException {
        if (isEmpty(node)) {
            return null;
        }
        String evaluateXPath = evaluateXPath(node, str);
        return evaluateXPath != null ? evaluateXPath.trim() : null;
    }

    private static String evaluateXPath(Node node, String str) {
        int i = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf("/", i);
            node = findChildNodeWithName(node, indexOf == -1 ? str.substring(i) : str.substring(i, indexOf));
            if (indexOf == -1) {
                break;
            }
            i = indexOf + 1;
        }
        return (node == null || node.getFirstChild() == null) ? node != null ? node.getNodeValue() : null : node.getFirstChild().getNodeValue();
    }

    private static Node findChildNodeWithName(Node node, String str) {
        if (node == null) {
            return null;
        }
        if (node.getNodeName().equals(str)) {
            return node;
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeName().equals(str)) {
                return childNodes.item(i);
            }
        }
        return null;
    }

    private static Node findXPathNode(Node node, String str) {
        int i = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf("/", i);
            node = findChildNodeWithName(node, indexOf == -1 ? str.substring(i) : str.substring(i, indexOf));
            if (indexOf == -1) {
                break;
            }
            i = indexOf + 1;
        }
        return node;
    }

    private static NodeList findXPathNodeList(Node node, String str) {
        int i = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf("/", i);
            node = findChildNodeWithName(node, indexOf == -1 ? str.substring(i) : str.substring(i, indexOf));
            if (indexOf == -1) {
                break;
            }
            i = indexOf + 1;
        }
        return node.getChildNodes();
    }

    public static boolean isEmpty(Node node) {
        return node == null;
    }

    private static boolean isEmptyString(String str) {
        return str == null || str.trim().equals(StringUtil.EMPTY_STRING);
    }

    public static int nodeLength(NodeList nodeList) {
        return nodeList == null ? 0 : nodeList.getLength();
    }
}
