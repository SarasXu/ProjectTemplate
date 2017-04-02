package com.saras.template;

import com.saras.template.annotation.AppBoot;
import com.saras.template.base.Boot;

/**
 * description: saras_xu@163.com 2017-04-01 16:22 创建
 */
@AppBoot(env = "local", port = 9096)
public class Main {
	public static void main(String[] args) {
		Boot.run(Main.class);
	}
}
