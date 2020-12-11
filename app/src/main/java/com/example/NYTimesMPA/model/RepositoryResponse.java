package com.example.NYTimesMPA.model;

import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mahmoud Zahran on 9, Dec, 2020
 */
@Entity(tableName = "favorite_table")
public class RepositoryResponse implements Serializable
{
//-----------------------------------com.example.NYTimes.java-----------------------------------
@PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Double numResults;
    @SerializedName("results")
    @Ignore
    @Expose
    private ArrayList<Result> results = null;



    @Ignore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public Double getNumResults() {
            return numResults;
        }

        public void setNumResults(Double numResults) {
            this.numResults = numResults;
        }

        public ArrayList<Result> getResults() {
            return results;
        }

        public void setResults(ArrayList<Result> results) {
            this.results = results;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }
    public class Result implements Serializable{

        @SerializedName("uri")
        @Expose
        private String uri;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("id")
        @Expose
        private Double id;
        @SerializedName("asset_id")
        @Expose
        private Double assetId;
        @SerializedName("source")
        @Expose
        private String source;
        @SerializedName("published_date")
        @Expose
        private String publishedDate;
        @SerializedName("updated")
        @Expose
        private String updated;
        @SerializedName("section")
        @Expose
        private String section;
        @SerializedName("subsection")
        @Expose
        private String subsection;
        @SerializedName("nytdsection")
        @Expose
        private String nytdsection;
        @SerializedName("adx_keywords")
        @Expose
        private String adxKeywords;
        @SerializedName("column")
        @Expose
        private String column;
        @SerializedName("byline")
        @Expose
        private String byline;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("_abstract")
        @Expose
        private String _abstract;
        @SerializedName("des_facet")
        @Expose
        private List<String> desFacet = null;
        @SerializedName("org_facet")
        @Expose
        private List<String> orgFacet = null;
        @SerializedName("per_facet")
        @Expose
        private List<Object> perFacet = null;
        @SerializedName("geo_facet")
        @Expose
        private List<String> geoFacet = null;
        @SerializedName("media")
        @Expose
        @Ignore
        private List<Medium> media = null;
        @SerializedName("eta_id")
        @Expose
        private Double etaId;

        private boolean expanded=false;

        public boolean isExpanded() {
            return expanded;
        }

        public void setExpanded(boolean expanded) {
            this.expanded = expanded;
        }

        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Double getId() {
            return id;
        }

        public void setId(Double id) {
            this.id = id;
        }

        public Double getAssetId() {
            return assetId;
        }

        public void setAssetId(Double assetId) {
            this.assetId = assetId;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getPublishedDate() {
            return publishedDate;
        }

        public void setPublishedDate(String publishedDate) {
            this.publishedDate = publishedDate;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getSubsection() {
            return subsection;
        }

        public void setSubsection(String subsection) {
            this.subsection = subsection;
        }

        public String getNytdsection() {
            return nytdsection;
        }

        public void setNytdsection(String nytdsection) {
            this.nytdsection = nytdsection;
        }

        public String getAdxKeywords() {
            return adxKeywords;
        }

        public void setAdxKeywords(String adxKeywords) {
            this.adxKeywords = adxKeywords;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String  column) {
            this.column = column;
        }

        public String getByline() {
            return byline;
        }

        public void setByline(String byline) {
            this.byline = byline;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAbstract() {
            return _abstract;
        }

        public void setAbstract(String _abstract) {
            this._abstract = _abstract;
        }

        public List<String> getDesFacet() {
            return desFacet;
        }

        public void setDesFacet(List<String> desFacet) {
            this.desFacet = desFacet;
        }

        public List<String> getOrgFacet() {
            return orgFacet;
        }

        public void setOrgFacet(List<String> orgFacet) {
            this.orgFacet = orgFacet;
        }

        public List<Object> getPerFacet() {
            return perFacet;
        }

        public void setPerFacet(List<Object> perFacet) {
            this.perFacet = perFacet;
        }

        public List<String> getGeoFacet() {
            return geoFacet;
        }

        public void setGeoFacet(List<String> geoFacet) {
            this.geoFacet = geoFacet;
        }

        public List<Medium> getMedia() {
            return media;
        }

        public void setMedia(List<Medium> media) {
            this.media = media;
        }

        public Double getEtaId() {
            return etaId;
        }

        public void setEtaId(Double etaId) {
            this.etaId = etaId;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }
    }
    public class Medium implements Serializable{

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("subtype")
        @Expose
        private String subtype;
        @SerializedName("caption")
        @Expose
        private String caption;
        @SerializedName("copyright")
        @Expose
        private String copyright;
        @SerializedName("approved_for_syndication")
        @Expose
        private Integer approvedForSyndication;
        @SerializedName("media-metadata")
        @Expose
        @Ignore
        private List<MediaMetadatum> mediaMetadata = null;

        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public Integer getApprovedForSyndication() {
            return approvedForSyndication;
        }

        public void setApprovedForSyndication(Integer approvedForSyndication) {
            this.approvedForSyndication = approvedForSyndication;
        }

        public List<MediaMetadatum> getMediaMetadata() {
            return mediaMetadata;
        }

        public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
            this.mediaMetadata = mediaMetadata;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }


        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
    public class MediaMetadatum implements Serializable {
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("format")
        @Expose
        private String format;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("width")
        @Expose
        private Integer width;

        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }


        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


}

