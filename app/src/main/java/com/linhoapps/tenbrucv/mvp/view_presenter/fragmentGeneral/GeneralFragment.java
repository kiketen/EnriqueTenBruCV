package com.linhoapps.tenbrucv.mvp.view_presenter.fragmentGeneral;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.linhoapps.tenbrucv.Application;
import com.linhoapps.tenbrucv.R;
import com.linhoapps.tenbrucv.utils.animations.ViewAnimation;
import com.linhoapps.tenbrucv.utils.listeners.AppBarChangeListener;
import com.linhoapps.tenbrucv.utils.listeners.CircleTransform;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.linhoapps.tenbrucv.mvp.view_presenter.activityMain.MainActivity.fragmentActual;
import static com.linhoapps.tenbrucv.mvp.view_presenter.activityMain.MainActivity.toolbarActImage;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.FAST_ANIM;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.MID_ANIM;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.SLOW_ANIM;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.animSpeed;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.delay;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.openCloseCard;

public class GeneralFragment extends Fragment implements GeneralView {

    @BindView(R.id.toolbar_image)
    ImageView toolbarImage;
    @BindView(R.id.profession)
    TextView profession;
    @BindView(R.id.toolbar_icon)
    ImageView toolbarIcon;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.title_education)
    TextView titleEducation;
    @BindView(R.id.btn_collapse_education_card)
    ImageButton btnCollapseEducationCard;
    @BindView(R.id.linear_lyt_title_education)
    RelativeLayout linearLytTitleEducation;
    @BindView(R.id.studies)
    TextView studies;
    @BindView(R.id.university)
    TextView university;
    @BindView(R.id.content_education)
    LinearLayout contentEducation;
    @BindView(R.id.cv_destinatario)
    CardView cvDestinatario;
    @BindView(R.id.title_contact)
    TextView titleContact;
    @BindView(R.id.btn_collapse_contact_card)
    ImageButton btnCollapseContactCard;
    @BindView(R.id.linear_lyt_title_contact)
    RelativeLayout linearLytTitleContact;
    @BindView(R.id.btn_phone)
    ImageButton btnPhone;
    @BindView(R.id.title_phone)
    TextView titlePhone;
    @BindView(R.id.lyt_phone)
    LinearLayout lytPhone;
    @BindView(R.id.btn_email)
    ImageButton btnEmail;
    @BindView(R.id.title_email)
    TextView titleEmail;
    @BindView(R.id.lyt_email)
    LinearLayout lytEmail;
    @BindView(R.id.btn_linkedin)
    ImageButton btnLinkedin;
    @BindView(R.id.title_linkedin)
    TextView titleLinkedin;
    @BindView(R.id.lyt_linkedin)
    LinearLayout lytLinkedin;
    @BindView(R.id.content_contact)
    LinearLayout contentContact;
    @BindView(R.id.cv_contact)
    CardView cvContact;
    @BindView(R.id.btn_collapse_languages_card)
    ImageButton btnCollapseLanguagesCard;
    @BindView(R.id.title_languages)
    TextView titleLanguages;
    @BindView(R.id.linear_lyt_title_languages)
    RelativeLayout linearLytTitleLanguages;
    @BindView(R.id.btn_spanish)
    ImageButton btnSpanish;
    @BindView(R.id.btn_catalan)
    ImageButton btnCatalan;
    @BindView(R.id.btn_english)
    ImageButton btnEnglish;
    @BindView(R.id.title_english)
    TextView titleEnglish;
    @BindView(R.id.title_catalan)
    TextView titleCatalan;
    @BindView(R.id.title_spanish)
    TextView titleSpanish;
    @BindView(R.id.content_languages)
    RelativeLayout contentLanguages;
    @BindView(R.id.cv_languages)
    CardView cvLanguages;
    @BindView(R.id.btn_collapse_description_card)
    ImageButton btnCollapseDescriptionCard;
    @BindView(R.id.title_description)
    TextView titleDescription;
    @BindView(R.id.linear_lyt_title_description)
    RelativeLayout linearLytTitleDescription;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.content_description)
    LinearLayout contentDescription;
    @BindView(R.id.cv_description)
    CardView cvDescription;
    @BindView(R.id.content_main)
    LinearLayout contentMain;
    @BindView(R.id.nameToolbar)
    TextView nameToolbar;

    private OnClickListener clickListener;
    private GeneralPresenterImpl presenter;
    private String actualState;
    private String previousState;
    private Handler handler;
    private Activity activity;

    public interface OnClickListener {
        // This can be any number of events to be sent to the activity
        void translateApp(String link);

        void startLinkedin();

    }

    // This event fires 1st, before creation of fragment or any views
    // The onAttach method is called when the Fragment instance is associated with an Activity.
    // This does not mean the Activity is fully initialized.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnClickListener) {
            this.clickListener = (OnClickListener) context;
        }
    }

    // This event fires 2nd, before views are created for the fragment
    // The onCreate method is called when the Fragment instance is being created, or re-created.
    // Use onCreate for any standard setup that does not require the activity to be fully created
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new GeneralPresenterImpl(this);
    }

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_general, parent, false);
        ButterKnife.bind(this, view);
        return view;
    }

    // This event is triggered soon after onCreateView().
    // onViewCreated() is only called if the view returned from onCreateView() is non-null.
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        toolbarActImage = toolbarIcon;
        fragmentActual = "general";
        activity = Application.getCurrentActivity();
        setPersonalActionBar();
        initializeVariables();
    }

    // This method is called when the fragment is no longer connected to the Activity
    // Any references saved in onAttach should be nulled out here to prevent memory leaks.
    @Override
    public void onDetach() {
        super.onDetach();
        this.clickListener = null;
    }

    // This method is called after the parent Activity's onCreate() method has completed.
    // Accessing the view hierarchy of the parent activity must be done in the onActivityCreated.
    // At this point, it is safe to search for activity View objects by their ID, for example.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setPersonalActionBar() {
        Picasso.with(activity).load(R.drawable.toolbar_image).transform(new CircleTransform()).into(toolbarIcon);
        Picasso.with(activity).load(R.drawable.toolbar_image).into(toolbarImage);
        toolbarIcon.setVisibility(View.INVISIBLE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        appBar.addOnOffsetChangedListener(new AppBarChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                actualState = state.name();
                presenter.changeToolbarState(actualState, previousState);
            }
        });
    }

    private void initializeVariables() {
        previousState = "EXPANDED";
        delay = 0;
        animSpeed = MID_ANIM;
        handler = new Handler();
    }

    @OnClick({R.id.toolbar_icon, R.id.btn_collapse_education_card, R.id.btn_collapse_contact_card,
            R.id.btn_phone, R.id.title_phone, R.id.lyt_phone, R.id.btn_email, R.id.title_email,
            R.id.lyt_email, R.id.btn_linkedin, R.id.title_linkedin, R.id.btn_collapse_languages_card,
            R.id.btn_spanish, R.id.btn_catalan, R.id.btn_english, R.id.title_english, R.id.title_catalan,
            R.id.title_spanish, R.id.btn_collapse_description_card})
    public void onClick(View view) {
        presenter.onClickActions(view.getId());
    }

    private void translateAndAnimateFlag(final ImageButton btnPushed, final String language) {
        animSpeed = SLOW_ANIM;
        ViewAnimation.moveToXYpoistionAndScale(btnPushed, titleSpanish, contentLanguages);
        makeInvisibleTexts();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewAnimation.scaleAlphaDown(btnPushed);
                clickListener.translateApp(language);
            }
        }, animSpeed);
    }

    private void makeInvisibleTexts() {
        titleEnglish.setVisibility(View.INVISIBLE);
        titleSpanish.setVisibility(View.INVISIBLE);
        titleCatalan.setVisibility(View.INVISIBLE);
    }

    private void startLinkedin() {
        clickListener.startLinkedin();
    }

    private void startSendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", getString(R.string.email_adress), null));
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    private void startPhoneCall() {
        presenter.checkPermisions();
    }

    @Override
    public void requestForSpecificPermission(String[] permissions) {
        ActivityCompat.requestPermissions(Application.getCurrentActivity(), permissions, 101);
    }

    @Override
    public void existPermissionPhoneCall() {

    }

    @Override
    public void toolbarCollapsed() {
        toolbarIcon.setVisibility(View.VISIBLE);
        nameToolbar.setVisibility(View.VISIBLE);
        ViewAnimation.scaleXYandAlpha(toolbarIcon);
        ViewAnimation.scaleAlpha(nameToolbar);
        previousState = "COLLAPSED";
    }

    @Override
    public void toolbarNoCollapsed() {
        ViewAnimation.scaleDownXYandAlpha(toolbarIcon);
        ViewAnimation.scaleDownAlpha(nameToolbar);
        previousState = "IDLE";

    }

    @Override
    public void startHelpScreen() {

    }

    @Override
    public void clickBtnCollapseEducationCard() {
        openCloseCard(contentEducation, btnCollapseEducationCard, contentMain);

    }

    @Override
    public void clickBtnCollapseContactCard() {
        openCloseCard(contentContact, btnCollapseContactCard, contentMain);

    }

    @Override
    public void clickBtnPhone() {
        ViewAnimation.moveTofinishX(btnPhone, titlePhone);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startPhoneCall();
            }
        }, animSpeed);

    }

    @Override
    public void clickBtnEmail() {
        ViewAnimation.moveTofinishX(btnEmail, titleEmail);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startSendEmail();
            }
        }, animSpeed);

    }

    @Override
    public void clickBtnLinkedin() {
        ViewAnimation.moveTofinishX(btnLinkedin, titleLinkedin);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startLinkedin();
            }
        }, animSpeed);

    }

    @Override
    public void clickTextPhone() {
        startPhoneCall();
    }

    @Override
    public void clickTextEmail() {
        startSendEmail();
    }

    @Override
    public void clickTextLinkedin() {
        startLinkedin();
    }

    @Override
    public void clickBtnLanguagesCard() {
        openCloseCard(contentLanguages, btnCollapseLanguagesCard, contentMain);

    }

    @Override
    public void startTranslateSpanish() {
        translateAndAnimateFlag(btnSpanish, "es");
    }

    @Override
    public void startTranslateCatalan() {
        translateAndAnimateFlag(btnCatalan, "ca");
    }

    @Override
    public void startTranslateEnglish() {
        translateAndAnimateFlag(btnEnglish, "en");
    }

    @Override
    public void clickBtnCollapseDescriptionCard() {
        openCloseCard(contentDescription, btnCollapseDescriptionCard, contentMain);

    }

    @Override
    public void noTranslateEnglish() {
        Toast.makeText(activity, R.string.is_translated_english, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noTranslateCatalan() {
        Toast.makeText(activity, R.string.is_translated_catalan, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noTranslateSpanish() {
        Toast.makeText(activity, R.string.is_translated_spanish, Toast.LENGTH_SHORT).show();
    }
}
