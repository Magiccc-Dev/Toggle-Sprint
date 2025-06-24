package dev.magic.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.text.Style;

public class Hud {
	protected MinecraftClient mc = MinecraftClient.getInstance();
    private boolean isSprintToggled = false;

    public void register() {
        HudRenderCallback.EVENT.register(this::renderSprintStatus);
    }

    public void showStatus(boolean isSprintToggled) {
        this.isSprintToggled = isSprintToggled;
    }

    private void renderSprintStatus(DrawContext drawContext, float tickDelta) {
        if (!isSprintToggled || mc == null || mc.textRenderer == null) {
            return;
        }

        int x = 10;  
        int y = 10; 

        Text textToRender = Text.literal("Sprint Toggled")
                .setStyle(Style.EMPTY.withColor(0xFFFFFF)); 

        drawContext.drawTextWithShadow(mc.textRenderer, textToRender, x, y, 0xFFFFFF);
    }
}
