package com.vitgon.collections.tree;

import com.vitgon.collections.dto.ScheduleDTO;

public class TreeTest {
	public static void main(String... args) {
		Tree monday = new Tree("monday");
		monday.add(1, "up", new ScheduleDTO("Bob", 36));
		System.out.println(monday);
	}
}
