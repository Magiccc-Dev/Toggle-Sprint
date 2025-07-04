package dev.magic.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class Hud {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private boolean isSprintToggled = false;

    public void register() {
        HudRenderCallback.EVENT.register(this::renderSprintStatus);
    }

    public void showStatus(boolean isSprintToggled) {
        this.isSprintToggled = isSprintToggled;
    }

    private void renderSprintStatus(MatrixStack matrices, float tickDelta) {
        if (!isSprintToggled || mc == null || mc.textRenderer == null) {
            return;
        }

        int x = 10;
        int y = 10;
        TextRenderer renderer = mc.textRenderer;

        String message = "Sprint Toggled";
        renderer.drawWithShadow(matrices, message, x, y, 0xFFFFFF);
    }
}
