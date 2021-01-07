package com.example.v2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class ARActivity2 extends AppCompatActivity {
    private ArFragment arFragment;
    private ModelRenderable modelRenderable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_r2);
        arFragment=(ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        setUpModel();
        setupPlane();

    }


    private void setUpModel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ModelRenderable.builder()
                    .setSource(this, R.raw.doormat)
                    .build()
                    .thenAccept(renderable -> modelRenderable = renderable)
                    .exceptionally(throwable -> {
                        Toast.makeText(ARActivity2.this,"Model can't be loaded", Toast.LENGTH_SHORT).show();
                        return null;
                    });
        }
    }

    private void setupPlane() {
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor=hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());

                createModel(anchorNode);
            }
        });
    }

    private void createModel(AnchorNode anchorNode) {
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        node.setParent(anchorNode);
        node.setRenderable(modelRenderable);
        node.select();
    }


}