package com.siteview.ecc.modle;

import java.util.List;
/**
 * 
 * @author lihua.zhong
 * ecc报警模块
 * alarmRule 报警规则
 */
public class EccAlarm {
	private List<AlarmRule> alarmRule;

	public List<AlarmRule> getAlarmRule() {
		return alarmRule;
	}

	public void setAlarmRule(List<AlarmRule> alarmRule) {
		this.alarmRule = alarmRule;
	}
	
}
