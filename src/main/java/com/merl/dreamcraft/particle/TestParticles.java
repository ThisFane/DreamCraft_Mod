package com.merl.dreamcraft.particle;

import com.merl.dreamcraft.registry.ModParticleRenderTypes;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.Random;

public class TestParticles extends TextureSheetParticle {
    
    
    protected TestParticles(ClientLevel pLevel, SpriteSet spriteSet, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
        this.friction = 0.8f;
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        
        this.quadSize *= 0.1f;
        this.lifetime = setLifetime();
        this.setSpriteFromAge(spriteSet);
        
        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
    }
    
    public float quadSize(){
        Random random = new Random();
        return 0.1F + random.nextFloat(-0.05F,0.225F);
    }
    
    public int setLifetime(){
        Random random = new Random();
        return 100+ random.nextInt(-99,20);
    }
    
    @Override
    public ParticleRenderType getRenderType() {
        return ModParticleRenderTypes.VERYLIGHT; //ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
    
    public static class Provider implements ParticleProvider<SimpleParticleType>{
        private final SpriteSet spriteSet;
        
        public Provider(SpriteSet spriteSet){
        this.spriteSet = spriteSet;
        }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed){
            return new TestParticles(level, this.spriteSet, pX, pY, pZ,  pXSpeed, pYSpeed, pZSpeed);
        }
    }
    
}
