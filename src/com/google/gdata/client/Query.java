package com.google.gdata.client;

import com.google.gdata.client.GDataProtocol.Parameter;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.ICategory;
import com.google.gdata.util.common.base.CharEscapers;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Query {
    public static final int UNDEFINED = -1;
    private String author;
    private List<CategoryFilter> categoryFilters;
    private List<CustomParameter> customParameters;
    private URL feedUrl;
    private String fields;
    private int maxResults;
    private DateTime publishedMax;
    private DateTime publishedMin;
    private String queryString;
    private ResultFormat resultFormat;
    private int startIndex;
    private boolean strict;
    private DateTime updatedMax;
    private DateTime updatedMin;

    public static class CategoryFilter {
        private final List<ICategory> categories;
        private final List<ICategory> excludeCategories;

        public List<ICategory> getCategories() {
            return this.categories;
        }

        public List<ICategory> getExcludeCategories() {
            return this.excludeCategories;
        }

        public CategoryFilter() {
            this.categories = new LinkedList();
            this.excludeCategories = new LinkedList();
        }

        public CategoryFilter(List<ICategory> included, List<ICategory> excluded) {
            if (included != null) {
                this.categories = included;
            } else {
                this.categories = new LinkedList();
            }
            if (excluded != null) {
                this.excludeCategories = excluded;
            } else {
                this.excludeCategories = new LinkedList();
            }
        }

        public CategoryFilter(ICategory category) {
            this();
            this.categories.add(category);
        }

        public void addCategory(ICategory category) {
            this.categories.add(category);
        }

        public void addExcludeCategory(ICategory category) {
            this.excludeCategories.add(category);
        }

        private String getQueryString(ICategory category) {
            StringBuilder sb = new StringBuilder();
            String scheme = category.getScheme();
            if (scheme != null) {
                sb.append("{");
                sb.append(scheme);
                sb.append("}");
            }
            sb.append(category.getTerm());
            return sb.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            boolean isFirst = true;
            for (ICategory category : this.categories) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    sb.append("|");
                }
                sb.append(getQueryString(category));
            }
            for (ICategory category2 : this.excludeCategories) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    sb.append("|");
                }
                sb.append("-");
                sb.append(getQueryString(category2));
            }
            return sb.toString();
        }
    }

    public static class CustomParameter {
        private String name;
        private String value;

        public CustomParameter(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return this.name;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum ResultFormat {
        DEFAULT("default"),
        ATOM("atom"),
        RSS("rss"),
        JSON("json"),
        JSONC("jsonc"),
        ATOM_IN_SCRIPT("atom-in-script"),
        RSS_IN_SCRIPT("rss-in-script"),
        JSON_IN_SCRIPT("json-in-script"),
        JSONC_IN_SCRIPT("jsonc-in-script"),
        JSON_XD("json-xd"),
        ATOM_SERVICE("atom-service");
        
        private String paramValue;

        private ResultFormat(String value) {
            this.paramValue = value;
        }

        public String paramValue() {
            return this.paramValue;
        }
    }

    public Query(URL feedUrl) {
        this.categoryFilters = new LinkedList();
        this.startIndex = UNDEFINED;
        this.maxResults = UNDEFINED;
        this.resultFormat = ResultFormat.DEFAULT;
        this.strict = false;
        this.customParameters = new ArrayList();
        this.feedUrl = feedUrl;
    }

    public URL getFeedUrl() {
        return this.feedUrl;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getFields() {
        return this.fields;
    }

    public void setFullTextQuery(String query) {
        this.queryString = query;
    }

    public String getFullTextQuery() {
        return this.queryString;
    }

    public void addCategoryFilter(CategoryFilter categoryFilter) {
        this.categoryFilters.add(categoryFilter);
    }

    public List<CategoryFilter> getCategoryFilters() {
        return Collections.unmodifiableList(this.categoryFilters);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setUpdatedMin(DateTime updatedMin) {
        this.updatedMin = updatedMin;
    }

    public DateTime getUpdatedMin() {
        return this.updatedMin;
    }

    public void setUpdatedMax(DateTime updatedMax) {
        this.updatedMax = updatedMax;
    }

    public DateTime getUpdatedMax() {
        return this.updatedMax;
    }

    public void setPublishedMin(DateTime publishedMin) {
        this.publishedMin = publishedMin;
    }

    public DateTime getPublishedMin() {
        return this.publishedMin;
    }

    public void setPublishedMax(DateTime publishedMax) {
        this.publishedMax = publishedMax;
    }

    public DateTime getPublishedMax() {
        return this.publishedMax;
    }

    public void setStartIndex(int startIndex) {
        if (startIndex == UNDEFINED || startIndex >= 1) {
            this.startIndex = startIndex;
            return;
        }
        throw new IllegalArgumentException("Start index must be positive");
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public void setMaxResults(int maxResults) {
        if (maxResults == UNDEFINED || maxResults >= 0) {
            this.maxResults = maxResults;
            return;
        }
        throw new IllegalArgumentException("Max results must be zero or larger");
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public void setResultFormat(ResultFormat resultFormat) {
        this.resultFormat = resultFormat;
    }

    public ResultFormat getResultFormat() {
        return this.resultFormat;
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    public boolean isStrict() {
        return this.strict;
    }

    public void addCustomParameter(CustomParameter customParameter) {
        if (customParameter == null) {
            throw new NullPointerException("Null custom parameter");
        }
        this.customParameters.add(customParameter);
    }

    public List<CustomParameter> getCustomParameters() {
        return this.customParameters;
    }

    public List<CustomParameter> getCustomParameters(String name) {
        List<CustomParameter> matchList = new ArrayList();
        for (CustomParameter param : this.customParameters) {
            if (param.name.equals(name)) {
                matchList.add(param);
            }
        }
        return matchList;
    }

    protected void appendQueryParameter(StringBuilder queryBuf, String paramName, String paramValue) throws UnsupportedEncodingException {
        queryBuf.append(queryBuf.length() != 0 ? '&' : '?');
        queryBuf.append(paramName);
        queryBuf.append("=");
        queryBuf.append(paramValue);
    }

    public boolean isValidState() {
        return this.resultFormat != ResultFormat.JSON_XD;
    }

    public URI getQueryUri() {
        if (isValidState()) {
            StringBuilder pathBuf = new StringBuilder();
            try {
                if (this.categoryFilters.size() != 0) {
                    pathBuf.append("-");
                    for (CategoryFilter categoryFilter : this.categoryFilters) {
                        pathBuf.append("/");
                        pathBuf.append(CharEscapers.uriEscaper().escape(categoryFilter.toString()));
                    }
                }
                StringBuilder queryBuf = new StringBuilder();
                if (this.queryString != null) {
                    appendQueryParameter(queryBuf, com.google.gdata.client.GDataProtocol.Query.FULL_TEXT, CharEscapers.uriEscaper().escape(this.queryString));
                }
                if (this.author != null) {
                    appendQueryParameter(queryBuf, com.google.gdata.client.GDataProtocol.Query.AUTHOR, CharEscapers.uriEscaper().escape(this.author));
                }
                if (this.resultFormat != ResultFormat.DEFAULT) {
                    appendQueryParameter(queryBuf, Parameter.ALT, this.resultFormat.paramValue());
                }
                if (this.updatedMin != null) {
                    appendQueryParameter(queryBuf, com.google.gdata.client.GDataProtocol.Query.UPDATED_MIN, CharEscapers.uriEscaper().escape(this.updatedMin.toString()));
                }
                if (this.updatedMax != null) {
                    appendQueryParameter(queryBuf, com.google.gdata.client.GDataProtocol.Query.UPDATED_MAX, CharEscapers.uriEscaper().escape(this.updatedMax.toString()));
                }
                if (this.publishedMin != null) {
                    appendQueryParameter(queryBuf, com.google.gdata.client.GDataProtocol.Query.PUBLISHED_MIN, CharEscapers.uriEscaper().escape(this.publishedMin.toString()));
                }
                if (this.publishedMax != null) {
                    appendQueryParameter(queryBuf, com.google.gdata.client.GDataProtocol.Query.PUBLISHED_MAX, CharEscapers.uriEscaper().escape(this.publishedMax.toString()));
                }
                if (this.startIndex != UNDEFINED) {
                    appendQueryParameter(queryBuf, com.google.gdata.client.GDataProtocol.Query.START_INDEX, Integer.toString(this.startIndex));
                }
                if (this.maxResults != UNDEFINED) {
                    appendQueryParameter(queryBuf, com.google.gdata.client.GDataProtocol.Query.MAX_RESULTS, Integer.toString(this.maxResults));
                }
                if (this.fields != null) {
                    appendQueryParameter(queryBuf, Parameter.FIELDS, CharEscapers.uriEscaper().escape(this.fields));
                }
                if (this.strict) {
                    appendQueryParameter(queryBuf, Parameter.STRICT, "true");
                }
                for (CustomParameter customParameter : this.customParameters) {
                    appendQueryParameter(queryBuf, CharEscapers.uriEscaper().escape(customParameter.name), CharEscapers.uriEscaper().escape(customParameter.value));
                }
                return new URI(pathBuf.toString() + queryBuf.toString());
            } catch (UnsupportedEncodingException uee) {
                throw new IllegalStateException("Unable to encode query URI", uee);
            } catch (URISyntaxException use) {
                throw new IllegalStateException("Unable to construct query URI", use);
            }
        }
        throw new IllegalStateException("Unsupported Query");
    }

    public URL getUrl() {
        try {
            String queryUri = getQueryUri().toString();
            if (queryUri.length() == 0) {
                return this.feedUrl;
            }
            String feedRoot = this.feedUrl.toString();
            StringBuilder urlBuf = new StringBuilder(feedRoot);
            if (!(feedRoot.endsWith("/") || queryUri.startsWith("?"))) {
                urlBuf.append('/');
            }
            urlBuf.append(queryUri);
            return new URL(urlBuf.toString());
        } catch (MalformedURLException mue) {
            throw new IllegalStateException("Unable to create query URL", mue);
        }
    }

    public final void setStringCustomParameter(String name, String value) {
        List<CustomParameter> customParams = getCustomParameters();
        for (CustomParameter existingValue : getCustomParameters(name)) {
            customParams.remove(existingValue);
        }
        if (value != null) {
            customParams.add(new CustomParameter(name, value));
        }
    }

    public final String getStringCustomParameter(String name) {
        List<CustomParameter> params = getCustomParameters(name);
        if (params.size() == 0) {
            return null;
        }
        return ((CustomParameter) params.get(0)).getValue();
    }

    public final void setIntegerCustomParameter(String name, Integer value) {
        if (value == null) {
            setStringCustomParameter(name, null);
        } else {
            setStringCustomParameter(name, value.toString());
        }
    }

    public final Integer getIntegerCustomParameter(String name) {
        String strValue = getStringCustomParameter(name);
        if (strValue == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(strValue));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
