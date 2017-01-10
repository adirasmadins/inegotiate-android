package com.amazonaws.services.s3.model;

import java.util.Map;

public class StaticEncryptionMaterialsProvider implements EncryptionMaterialsProvider {
    private final EncryptionMaterials materials;

    public StaticEncryptionMaterialsProvider(EncryptionMaterials encryptionMaterials) {
        this.materials = encryptionMaterials;
    }

    public EncryptionMaterials getEncryptionMaterials() {
        return this.materials;
    }

    public EncryptionMaterials getEncryptionMaterials(Map<String, String> map) {
        if (map.equals(this.materials.getMaterialsDescription())) {
            return this.materials;
        }
        EncryptionMaterialsAccessor accessor = this.materials.getAccessor();
        return accessor == null ? null : accessor.getEncryptionMaterials(map);
    }

    public void refresh() {
    }
}
