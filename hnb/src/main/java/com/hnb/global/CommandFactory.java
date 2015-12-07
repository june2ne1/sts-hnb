package com.hnb.global;

import com.hnb.global.Command;

public class CommandFactory {
	public Command createCommand(String action, String page){
		return new Command(action, page);
	}
}
