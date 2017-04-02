package com.saras.template;

import com.google.common.collect.Lists;
import com.saras.template.config.ConfigProperty;
import com.saras.template.entity.User;
import com.saras.template.mapper.UserMapper;
import com.saras.template.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * description: saras_xu@163.com 2017-03-10 15:31 创建
 */
@Controller
public class TestController {
	private final static Logger logger = LoggerFactory.getLogger(TestController.class);
	@Autowired
	private ConfigProperty configProperty;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	@Autowired
	private TransactionTemplate transactionTemplate;
//	@Autowired
//	private RedisTemplate redisTemplate;
	
	@RequestMapping("hello")
	public String hello(Model model) {
		List<String> list = Lists.newArrayList();
		list.add("hello");
		list.add(configProperty.getName());
		list.add("velocity");
		doBiz("no");
//		ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
//		valueOperations.set("one","667787889");
		User user = userMapper.selectByPrimaryKey(1l);
		taskExecutor.execute(() -> logger.info("这里是线程池中的多线程"));
		logger.info("user：{}", user);
//		logger.info(valueOperations.get("one"));
		model.addAttribute("list", list);
		logger.info("hello info：{}", list);
		logger.warn("hello warn：{}", list);
		logger.error("hello error：{}", list);
		return "hello";
	}
	
	protected void doBiz(String cmd) {
		Biz biz = new Biz(cmd);
		transactionTemplate.execute(biz);
	}
	
	private class Biz implements TransactionCallback<Void> {
		private String cmd;
		
		public Biz(String cmd) {
			this.cmd = cmd;
		}
		
		@Override
		public Void doInTransaction(TransactionStatus transactionStatus) {
			try {
				logger.info("启动编程式事务管理");
				User user = new User();
				String value = "taiajaja";
				user.setDdd(value);
				user.setUser_id(value);
				user.setUser_name(value);
				user.setMemo(value);
				user.setPwd(value);
				userMapper.insert(user);
				
				if ("back".equals(cmd)) {
					throw new IllegalStateException("测试回滚");
				}
			} catch (Exception e) {
				transactionStatus.setRollbackOnly();
				logger.info("回滚插入");
				//				throw e;
			}
			return null;
		}
	}
}
