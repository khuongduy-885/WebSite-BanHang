package com.khuongduy.controller.command;

import com.khuongduy.common.command.AbstractCommand;
import com.khuongduy.dto.UserDTO;

public class UserCmonmand extends AbstractCommand<UserDTO> {
	public UserCmonmand() {
		this.pojo= new UserDTO();
	}

}
