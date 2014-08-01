package com.kryptonite.constants;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;

public final class NPLabels {

	public static Label ACHIEVER = DynamicLabel.label("achiever");
	public static Label ENABLER = DynamicLabel.label("enabler");
	public static Label FOLLOWER = DynamicLabel.label("follower");
	public static Label USER = DynamicLabel.label("user");
	public static Label DREAM = DynamicLabel.label("dream");
	public static Label CATEGORY = DynamicLabel.label("category");
	public static Label NOTIFICATION = DynamicLabel.label("notification");
	public static Label MESSAGE = DynamicLabel.label("message");
}
