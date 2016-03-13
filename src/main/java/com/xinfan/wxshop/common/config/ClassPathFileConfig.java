package com.xinfan.wxshop.common.config;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

/**
 * 
 * 文件配置管理
 * 
 * @author cyp
 * 
 */
public class ClassPathFileConfig {

	public static File getClassPathFile(String filename) {

		ClassPathResource loader = new ClassPathResource(filename);
		try {
			return loader.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
