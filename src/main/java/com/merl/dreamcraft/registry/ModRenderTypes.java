package com.merl.dreamcraft.registry;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;

public interface ModRenderTypes extends ParticleRenderType {
    
    
    ParticleRenderType VeryLight = new ParticleRenderType() {
        public void begin(BufferBuilder p_107462_, TextureManager p_107463_) {
            RenderSystem.disableBlend();
            RenderSystem.depthMask(false);
            RenderSystem.setShader(GameRenderer::getRendertypeEntityGlintShader);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            p_107462_.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
        }
    
        public void end(Tesselator p_107451_) {
            p_107451_.end();
        }
    
        public String toString() {
            return "VERYLIGHT";
        }
    };
    
    
    ParticleRenderType MyEnd = new ParticleRenderType() {
        public void begin(BufferBuilder p_107462_, TextureManager p_107463_) {
            RenderSystem.disableBlend();
            RenderSystem.depthMask(false);
            RenderSystem.setShader(GameRenderer::getRendertypeEndPortalShader);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            p_107462_.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
        }
        
        public void end(Tesselator p_107451_) {
            p_107451_.end();
        }
        
        public String toString() {
            return "MYEND";
        }
    };
    
    
}
