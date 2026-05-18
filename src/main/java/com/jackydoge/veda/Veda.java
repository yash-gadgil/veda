package com.jackydoge.veda;

import com.jackydoge.veda.creativemodetab.ModCreativeModeTabs;
import com.jackydoge.veda.dimension.ModDimensions;
import com.jackydoge.veda.effect.ImmortalMobEffect;
import com.jackydoge.veda.effect.ModEffects;
import com.jackydoge.veda.item.ModConsumables;
import com.jackydoge.veda.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Veda implements ModInitializer {
	public static final String MOD_ID = "veda";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModDimensions.registerDimensions();
		ModEffects.registerModEffects();
		ModItems.registerModItems();
		ModConsumables.registerModConsumables();
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ImmortalMobEffect.registerEvents();
	}
}