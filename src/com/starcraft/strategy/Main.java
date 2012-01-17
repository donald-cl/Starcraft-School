package com.starcraft.strategy;

import android.app.Activity;
import android.View;
import android.widget.ProgressBar;
import android.os.Bundle;
import java.util.ArrayList;
import java.sql.Timestamp;

public class Main extends Activity {
	
	public final int conversion = 1000;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*********
         * Units *
         *********/
        
        Item Probe = new Item("Probe", 1, new TimeStamp(17*conversion));
        Item Zealot = new Item("Zealot", 2, new TimeStamp(38*conversion));
        Item Stalker = new Item("Stalker", 2, new TimeStamp(42*conversion));
        Item HighTemplar = new Item("High Templar", 2, new TimeStamp(55*conversion));
        Item DarkTemplar = new Item("Dark Templar", 2, new TimeStamp(55*conversion));
        Item Immortal = new Item("Immortal", 4, new TimeStamp(55*conversion));
        Item Colossus = new Item("Colossus", 6, new TimeStamp(75*conversion));
        Item Observer = new Item("Observer", 1, new TimeStamp(40*conversion));
        Item WarpPrism = new Item("Warp Prism", 2, new TimeStamp(50*conversion));
        Item Phoenix = new Item("Phoenix", 2, new TimeStamp(35*conversion));
        Item Void Ray = new Item("Void Ray", 2, new TimeStamp(60*conversion));
        Item Carrier = new Item("Carrier", 2, new TimeStamp(120*conversion));
        Item Mothership = new Item("Mothership", 2, new TimeStamp(160*conversion));
        
        
        /*********
         * Buildings *
         *********/
        
        Item Nexus = new Item("Nexus", 0, new TimeStamp(100*conversion));
        Item Pylon = new Item("Pylon", 0, new TimeStamp(25*conversion));
        Item Cannon = new Item("Cannon", 0, new TimeStamp(40*conversion));
        Item Forge = new Item("Forge", 0, new TimeStamp(45*conversion));
        Item Assimilator = new Item("Assimilator", 0, new TimeStamp(30*conversion));
        Item Gateway = new Item("Gateway", 0, new TimeStamp(65*conversion));
        Item CyberneticsCore = new Item("Cybernetics Core", 0, new TimeStamp(50*conversion));
        Item RoboticsFacility = new Item("Robotics Facility", 0, new TimeStamp(65*conversion));
        Item Stargate = new Item("Stargate", 0, new TimeStamp(60*conversion));
        Item TwilightCouncil = new Item("Twilight Council", 0, new TimeStamp(50*conversion));
        Item TemplarArchives = new Item("Templar Archives", 0, new TimeStamp(50*conversion));
        Item DarkShrine = new Item("Dark Shrine", 0, new TimeStamp(100*conversion));
        Item RoboticsBay = new Item("Robotics Bay", 0, new TimeStamp(65*conversion));
        
        /*********
         * Upgrades *
         *********/
        
        Item GroundWeapons = new Item("Ground Weapons", 0, new TimeStamp(160*conversion));
        Item GroundWeapons2 = new Item("Ground Weapons Level 2", 0, new TimeStamp(190*conversion));
        Item GroundWeapons3 = new Item("Ground Weapons Level 3", 0, new TimeStamp(220*conversion));
        Item GroundArmor = new Item("Ground Armor", 0, new TimeStamp(160*conversion));
        Item GroundArmor2 = new Item("Ground Armor Level 2", 0, new TimeStamp(190*conversion));
        Item GroundArmor3 = new Item("Ground Armor Level 3", 0, new TimeStamp(220*conversion));
        Item Shields = new Item("Shields", 0, new TimeStamp(160*conversion));
        Item Shields2 = new Item("Shields Level 2", 0, new TimeStamp(190*conversion));
        Item Shields3 = new Item("Shields Level 3", 0, new TimeStamp(220*conversion));
        
        Item Charge = new Item("Charge", 0, new TimeStamp(140*conversion));
        Item Blink = new Item("Blink", 0, new TimeStamp(140*conversion));
        
        Item PsionicStorm = new Item("Psionic Storm", 0, new TimeStamp(110*conversion));
        Item Hallucination = new Item("Hallucination", 0, new TimeStamp(80*conversion));
        
        Item ThermalLance = new Item("Extended Thermal Lance", 0, new TimeStamp(140*conversion));
        
        Item ChronoBoost = new Item("Chrono Boost", 0, new TimeStamp(20*conversion));
        
        BuildOrder ForgeFastExpand = new BuildOrder("Forge Fast Expand");
        BuildOrderNode 9Pylon = new BuildOrderNode(Pylon, 9, new TimeStamp());
        BuildOrderNode 9Boost = new BuildOrderNode(ChronoBoost, 9, new TimeStamp());
        BuildOrderNode 13Forge = new BuildOrderNode(Forge, 13, new TimeStamp());
        BuildOrderNode 17Nexus = new BuildOrderNode(Nexus, 17, new TimeStamp());
        BuildOrderNode 17Cannon = new BuildOrderNode(Cannon, 17, new TimeStamp());
        ForgeFastExpand.addItem(9Pylon);
        ForgeFastExpand.addItem(9Boost);
        ForgeFastExpand.addItem(13Forge);
        ForgeFastExpand.addItem(17Nexus);
        ForgeFastExpand.addItem(17Cannon);
        BuildNote ForgeFastExpandNote1 = new BuildNote(
        		"This build takes advantage of the fact that a protoss with the same economy as a zerg is stronger." +
        		"By matching the zerg's expansion timing which is regularly around (15 supply) you are able to gain an " +
        		"advantage. In addition, the zerg must sacrifice workers to build their first hatchery, extractor and queen" +
        		"while protoss can constantly produce workers and chrono boost for free. The advantage is off-set by the fact" +
        		"that the protoss must make cannons under the threat of a possible ling run-by. Consider the number of lings your" +
        		"opponent produces to decide on how many cannons you may need. It is possible you will not need a cannon at 17 supply if " +
        		"no zerglings are made. Similarly it may be even more advantageous to build a nexus before forge around 15 supply."
        		);
        ForgeFastExpand.addNote(ForgeFastExpandNote1);
        
    }
    
    public class BuildOrder {
    	public String name;
    	public ArrayList<BuildOrderNode> finishedNodes;
    	public ArrayList<BuildOrderNode> buildList;
    	public ArrayList<BuildNote> buildNotes;
    	
    	public int usedSupply;
    	public int availableSupply;
    	
    	public BuildOrder(String s) {
    		name = s;
    	}
    	
        public void addItem(BuildOrderItem node) {
        	if (node != null)
        	buildList.add(node);
        }
        
        public void addNote(BuildNote note) {
        	if (note != null)
        	buildNotes.add(note);
        }
        
    }
    
    public class BuildNote {
    	public String description;
    	
    	public BuildNote(String s) {
    		description = s;
    	}
    }

    public class BuildOrderNode {
    	private Item item;
    	private int supplyMark;
    	private TimeStamp time;

    	private progressBar pb;
    	private Handler pbHandler;
    	
    	public BuildOrderNode(Item i, int s, TimeStamp t) {
    		if (i != null) {  item = i; }
    		if (s > 0) { supplyMark = s; }
    		time = t;
    		pb = new ProgressBar(Main, null, android.R.attr.progressBarStyleSmall);
    		pbHandler = new Handler();
    	}
    	
    	public void buildNode() {
            new Thread(new Runnable() {
                public void run() {
                    while (pb < 100) {
                        pb = doWork();

                        // Update the progress bar
                        pbHandler.post(new Runnable() {
                            public void run() {
                                pb.setProgress(mProgressStatus);
                            }
                        });
                    }
                }
            }).start();
    	}
    }
    
    public class Item {
    	private TimeStamp buildTime;
    	private String name;
    	private int supplyCost;
    	private int mineralCost;
    	private int gasCost;
    	
    	
    	public Item(String i, int s, TimeStamp t) {
    		if (i.trim.length > 0) {  name = i; }
    		if (s > 0) { supplyCost = s; }
    		buildTime = t;
    		
    	}
    	
    	public Item(String i, int s, TimeStamp t, int mc, int gc) {
    		if (i.trim.length > 0) {  name = i; }
    		if (s > 0) { supplyCost = s; }
    		if (mc > 0) { mineralCost = mc; }
    		if (gc > 0) { gasCost = gc; }
    		buildTime = t;
    		
    	}
    }
    
}