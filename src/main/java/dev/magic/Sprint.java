package dev.magic;

import org.lwjgl.glfw.GLFW;
import dev.magic.hud.Hud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class Sprint implements ClientModInitializer {
    public static KeyBinding toggleSprintKey;
    public static boolean isSprintToggled = false;
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private static final Hud hud = new Hud();

    @Override
    public void onInitializeClient() {
        hud.register();

        toggleSprintKey = new KeyBinding(
            "key.toggle_sprint.toggle",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_ALT,
            "key.categories.toggle_sprint"
        );
        KeyBindingHelper.registerKeyBinding(toggleSprintKey);
    }

    public static void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        
        if (mc.world == null || mc.player == null) return;
        
        while (toggleSprintKey.wasPressed()) {
            isSprintToggled = !isSprintToggled;
            hud.showStatus(isSprintToggled);
        }
        if (isSprintToggled) {
            mc.player.setSprinting(mc.player.input.pressingForward);
        }
    }
}
