package com.guozha.deliveryserver.web.adapter.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.configuration.ConfigurationException;

import com.guozha.deliveryserver.framework.config.AppConfiguration;

public class AppContextInitListener implements ServletContextListener,
		HttpSessionListener {

	private static final String	ETC_FILE	= "etc_file";

	public AppContextInitListener() {

	}

	public void contextDestroyed(ServletContextEvent event) {

		AppConfiguration.getInstance().clear();
	}

	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String configFile = context.getInitParameter(ETC_FILE);//获取web.xml中<context-param/>配置中<param-name/>为etc_file的<param-value/>的值

		try {
			AppConfiguration.init(context.getRealPath(configFile));//初始化DWZ配置 D:\Workspaces\MPOSS\WebRoot\WEB-INF\etc\conf\app-config.xml
		} catch (ConfigurationException e) {
			event.getServletContext().log("ConfigurationException: ", e);
		}

	}

	public void sessionCreated(HttpSessionEvent event) {
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		session.invalidate();
	}

}
