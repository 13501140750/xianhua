package com.jifenbao.service.mail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerConfiguration {

    private final static Logger LOG = Logger.getLogger(FreeMarkerConfiguration.class);

    private String rootPath;

    private String encoding = "UTF-8";

    private String template;

    public String generateContent(ServletContext context, Map<String, Object> params) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setServletContextForTemplateLoading(context, getRootPath());
        cfg.setDefaultEncoding(getEncoding());
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Template t;
        try {
            t = cfg.getTemplate(getTemplate());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Writer out = new OutputStreamWriter(baos);
            t.process(params, out);
            out.flush();
            return baos.toString();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        } catch (TemplateException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

}
