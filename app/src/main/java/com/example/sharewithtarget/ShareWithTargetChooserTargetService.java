package com.example.sharewithtarget;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.os.Bundle;
import android.service.chooser.ChooserTarget;
import android.service.chooser.ChooserTargetService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShareWithTargetChooserTargetService extends ChooserTargetService {
    @Override
    public List<ChooserTarget> onGetChooserTargets(ComponentName targetActivityName,
                                                   IntentFilter matchedFilter) {
        ComponentName componentName = new ComponentName(getPackageName(),
                MainActivity.class.getCanonicalName());
        // The list of Direct Share items. The system will show the items the way they are sorted
        // in this list.
        ArrayList<ChooserTarget> targets = new ArrayList<>();
        for (int i = 0; i < Targets.Items.size(); ++i) {
            Bundle extras = new Bundle();
            extras.putInt("target_index", i);
            targets.add(new ChooserTarget(
                    // The name of this target.
                    Targets.Items.get(i),
                    // The icon to represent this targe 2t.
                    null,
                    // The ranking score for this target (0.0-1.0); the system will omit items with
                    // low scores when there are too many Direct Share items.
                    0.5f,
                    // The name of the component to be launched if this target is chosen.
                    componentName,
                    // The extra values here will be merged into the Intent when this target is
                    // chosen.
                    extras));
        }
        return targets;
    }
}
class Targets {
    public static List<String> Items = Arrays.asList("target 1", "target 2", "target 3", "target 4", "target 5");
}
