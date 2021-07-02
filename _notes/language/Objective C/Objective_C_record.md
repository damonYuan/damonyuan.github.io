Objective_C_record
==============

Objective_C_record

# Find View's ViewController

# Swizzling -> http://nshipster.com/method-swizzling/

# UI test
  https://github.com/kif-framework/KIF

# AFJSONRequestSerializer 
 [requestSerializer setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
 set JSON data in body
 @"Accept" for HTTPHeaderField is for Content-Types that are acceptable for the response;

# When would layout subview been called
  1. init does not cause layoutSubviews to be called (duh)
  2. addSubview causes layoutSubviews to be called on the view being added, the view it’s being added to (target view), and all the subviews of the target
  3. view setFrame intelligently calls layoutSubviews on the view having its frame set only if the size parameter of the frame is different
  4. scrolling a UIScrollView causes layoutSubviews to be called on the scrollView, and its superview
rotating a device only calls layoutSubview on the parent view (the responding viewControllers primary view)
  5. Resizing a view will call layoutSubviews on its superview

# drawRect
  Changing the frame rectangle automatically redisplays the receiver without invoking the drawRect: method. If you want the drawRect: method invoked when the frame rectangle changes, set the contentMode property to UIViewContentModeRedraw.

  If you want the view to redraw just call setNeedsDisplay on it and you should be fine (or, as the docs say, you can set it to UIViewContentModeRedraw, but it is up to you)

# UIView
  1. init methods
     self.autoresizingMask
     self.backgroundColor
     other init customization

  2. - (void)drawRect:(CGRect)rect (inherit)
     do CoreGraphics things

  3. - (void)layoutSubviews (inherit)
     init subviews and frame

  4. use setNeedsDisplay setNeedsDisplayInRect
     and displayIfNeeded to redraw right away

# UIViewController
  1. - (void)loadView
  2. - (void)viewDidLoad
  3. - (void)viewWillLayoutSubviews to set frame

# data page sequence
  0. - (void)init -> - (void)loadDefaults (some default settings)
  1. - (void)loadView -> basic view frame
  2. - (void)viewDidLoad -> alloc view factors
  3. - (void)layoutSubviews -> autolayout
  4. - (void)viewWillAppear -> call - (void)initData and validate it
  5. Actions
  6. Before save -> - (Bool)isDataValid
  7. save

  Note:
  Everytime press a button first endEditing:

# Localization
  To generate strings from *.m files located in the current folder execute:

  1.
  $ genstrings -o en.lproj *.m
  To generate strings from *.m files located in the current folder + subfolders execute:

  2.
  $ find . -name *.m | xargs genstrings -o en.lproj
  If you find that you get the an error of ‘unknown primary or operator’ when running the above find command, it is because you need to wrap the *.m in quotes – as follows:

  3.
  find . -name ‘*.m’ | xargs genstrings -o en.lproj
  To generate strings from *.m files located in the current folder + subfolders but excluding Folder1 execute:

  4.
  $ find . -name *.m -not -path "./Folder1/*" -print0 | xargs -0 genstrings -o en.lproj -1

  The basic genstrings syntax is shown below (for the full details please refer to the command’s man page):
  genstrings [-a] [-s <routine>] [-q] [-o <outputDir>] sourcefile(s)

  Options:

  -a  appends the command output to previously generated/existing files.
  -s  replaces NSLocalizedString* with a different routine e.g.: – s SBLocalizedString. This will catch all calls in the code to SBLocalizedString and SBLocalizedStringFromTable.
  -q  turns off multiple key/value pairs warnings.
  -o  output folder.

  find . -name *.m | xargs genstrings -o /Users/Damon/Desktop/BindoLabs/BindoPOS/POS/Support\ Files/en.lproj

# About Multipeer Cosnnectivity
  The Multipeer Connectivity framework provides support for discovering services provided by nearby iOS devices using infrastructure Wi-Fi networks, peer-to-peer Wi-Fi, and Bluetooth personal area networks and subsequently communicating with those services by sending message-based data, streaming data, and resources (such as files).

# Find the intranet device
  Bonjour SDK

????# - (void)drawRect:(CGRect)rect
  do the cg layer things


# DataModel
  1. - (void)reload
  2. @property (nonatomic, strong) NSMutableArray *items;
  
# Navigationbar button
  [29/1/15 10:06:57 pm] Levey:  [[UIBarButtonItem alloc] initWithTitle:@"Done"
                                         style:UIBarButtonItemStyleDone
                                        target:self
                                        action:@selector(_done:)];
  [29/1/15 10:07:33 pm] Levey: Use         
  [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemDone target:self action:@selector(_done:)]; for auto localization

# Localization
  1. https://github.com/nanaimostudio/Xcode-Quick-Localization (quick typing)
  2. https://github.com/stefanceriu/SCStringsUtility (choosing existing localization)
  3. https://github.com/questbeat/Lin 


# - awakeFromNib
  It is sent to all object that are instantiated from the nib after all nib objects have instantiated. The owner is not one of those objects. It exists prior to deserializing the nib and is wired to the nib after locading, so t is not sent -awakeFromNib(unless of course it is instantiated by some other nib itself);

  The nib locader always calls -initWithCoder:, -initWithFrame or -init(the rules for which is sent are in the Nib Object Life Cycle). The fact that you have some other designated initializer strongly suggests that you're manually creating this object somewhere in the code, which means this object is not awaken from nib.

# keyboard on modal view not dismissed
   In Xib, if set topbar opaque, the keyboard cannot be dismissed; if set to inferred, it can be dismissed.

# calculate textField height
   CGSize maximumLabelSize = CGSizeMake(<#label#>.frame.size.width,0);
        NSDictionary *attributes = @{NSFontAttributeName: <#label#>.font};
        CGRect expectedLabelRect = [deliveryNote.address boundingRectWithSize:maximumLabelSize
                                                                      options:NSStringDrawingTruncatesLastVisibleLine |NSStringDrawingUsesLineFragmentOrigin | NSStringDrawingUsesFontLeading
                                                                   attributes:attributes
                                                                      context:NULL];
        CGFloat expectedHeight = expectedLabelRect.size.height;

# KIF Text entry error issue;
 The workaround I've been using for this issue is to tap the view I want to enter text into before entering the text. The enterText:intoViewWithAccessabilityLabel method already does this, but it doesn't seem to help. This seems to delay the keyboard appearance long enough that is is fully on the screen when typing begins.

So, I would expect this to work for you:
 
[tester tapViewWithAccessabilityLabel:@"username"]; 
[tester enterText:@"billsmith23" intoViewWithAccessibilityLabel:@"username"];
 
 # iOS7 crash at “Auto Layout still required after executing -layoutSubviews” when using iOS8 SDK
   -(void)layoutSubviews
   {
        [super layoutSubviews];
        [self layoutIfNeeded]; // this line is key
   }

#  SimPholders open folders for sqlite

# Assign the delegate after adding the gesture recognizer to the view. Otherwise, the action method won’t be called.

#  If you invalidate a unfired NSTimer, that’s fine. But if you invalidate a fired NSTimer, the application will crashed. http://eureka.ykyuen.info/2010/06/08/iphone-stop-the-scheduled-nstimer/

But also, the notification and the timer task should be in the same thread.

# AlertViews are 'accessible by default'. This, and the fact that the buttons aren't editable, means that you probably shouldn't try changing the accessibilityLabels yourself. By default they use the button's title and the word 'button', which should be fine.

# It is easy to crash at the point of NSArray out of range 
  should check if it is inside the range

# iteration should be on the same thread or it is easy to make it crash or strang behavior.

# iOS instruments
  1. time for profiling
  2. Allocations:
     1. Simulate a memory warning by selecting HardwareSimulate Memory Warning in the iOS simulator's menu bar because it could be something in the depths of UIKit that's holding onto memory.
     2. The parts of the stack trace in grey are in system libraries (cmd3: extended details). This is for "unbounded memory growth", this happens where memory continues to be allocated and is never given a chance to be deallocated.
  3. leak: this is used when an object is no longer referenced by anything, and eats up memory.
     !! ARC only deals with Objective-C objects. It doesn't manage the retain and release of CoreFoundation objects which are not objective-C objects.
     UIGraphicsEndImageContext();
     CGImageRelease(newCGImage);
     CGContextRelease(context);

# SDKs: intercom

# Notification:
  NSNotification should be added in init, it cannot be added in dispatch_once or the observer will not be registered.

# /Applications/Xcode.app/Contents/Developer/Platforms/iPhoneOS.platform/Developer/SDKs/iPhoneOS.sdk/System/Library/Frameworks/ (where all the other Apple Frameworks are located btw) 

# If add button to a cell, you should either add it to contentView or setUserInteractionEnabled: to YES to its superview.

# UITextField
 having a rightView will override the clear button
  - (id) init
{
    // init elements
    UITextField *txt_password      = [[UITextField alloc] init];
    UIView *txt_password_paddingVc = [[UIView alloc] initWithFrame:CGRectMake(0,0,10,35)];

    // configure  txtfield
    [txt_password setSecureTextEntry:YES];
    [txt_password setDelegate:self];
    [txt_password setTag:100];
    [txt_password setPlaceholder:t(@"App Password")];
    [txt_password setLeftView:txt_password_paddingVc];
    [txt_password setRightView:txt_password_paddingVc];
    [txt_password setBackgroundColor:[UIColor whiteColor]];
    [txt_password setLeftViewMode:UITextFieldViewModeAlways];
    [txt_password setRightViewMode:UITextFieldViewModeAlways];
    [txt_password setTranslatesAutoresizingMaskIntoConstraints:NO];
    [txt_password setAutocapitalizationType:UITextAutocapitalizationTypeNone];
    [txt_password setAutocorrectionType:UITextAutocorrectionTypeNo];
    [txt_password.layer setBorderColor:[UIColor colorWithRed:228/255.0 green:228/255.0 blue:228/255.0 alpha:1].CGColor];
    [txt_password.layer setBorderWidth:1.0f];
    [txt_password.layer setShadowOpacity:0.0];
    [txt_password.layer setMasksToBounds:YES];

    // make round corners for txtfield
    CAShapeLayer *passwordMaskLayer = [[CAShapeLayer alloc] init];
    UIBezierPath *passwordMaskPathWithRadiusTop = [UIBezierPath bezierPathWithRoundedRect:txt_password.bounds byRoundingCorners:(UIRectCornerTopLeft | UIRectCornerTopRight) cornerRadii:CGSizeMake(5.0, 5.0)];
    passwordMaskLayer.frame     = txt_password.bounds;
    passwordMaskLayer.path      = passwordMaskPathWithRadiusTop.CGPath;
    passwordMaskLayer.fillColor = [UIColor whiteColor].CGColor;
    [txt_password.layer.mask setMask:passwordMaskLayer];

    // add txtfield to view
    [self.view addSubview:txt_password];

     return self;
    }
    setClearButtonMode

# When use isEqual: ensure the two ends are not nil.

# Edit status
  Edit -> data from data_modal -> Editing on the view -> save -> reflect the changes on data_modal

# flip view
  -(void)viewDidLoad{
    [super viewDidLoad];
    UIButton *btnFlip = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    btnFlip.frame = CGRectMake(10, 10, 50, 30);
    [btnFlip setTitle:@"flip" forState:UIControlStateNormal];
    [btnFlip addTarget:self action:@selector(flip) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:btnFlip];

    panel = [[UIView alloc] initWithFrame:CGRectMake(10, 40, 300,300)];
    panel.backgroundColor = [UIColor darkGrayColor];
    [self.view addSubview:panel];

    panelBack = [[UIView alloc] initWithFrame:CGRectMake(10, 40, 280, 200)];
    panelBack.tag = 1;
    panelBack.backgroundColor = [UIColor brownColor];
    [panel addSubview:panelBack];

    panelFront = [[UIView alloc] initWithFrame:CGRectMake(10, 40, 280, 200)];
    panelFront.tag = 2;
    panelFront.backgroundColor = [UIColor whiteColor];
    [panel addSubview:panelFront];

    displayingFront = TRUE;
}

-(void)flip{

    [UIView transitionWithView:panel 
    duration:0.5
    options:(displayingFront ? UIViewAnimationOptionTransitionFlipFromRight : UIViewAnimationOptionTransitionFlipFromLeft)
    animations:^{ 
        if (displayingFront) {
            //panelFront.hidden=TRUE;
            //panelBack.hidden = FALSE;
            [panelFront removeFromSuperview];
            [panel addSubview:panelBack];
        }else{
            //panelFront.hidden=FALSE;
            //panelBack.hidden = TRUE;
            [panelBack removeFromSuperview];
            [panel addSubview:panelFront];
        }
     }
     completion:^(BOOL finished){
         displayingFront = !displayingFront;
     }];
}


If your ints are A and B and you want to have ceil(A/B) just calculate (A+B-1)/B

# When zombies are enable everything is affected as objects are not deallocated. This fills up the memory very fast in the case of a table view where a lot of thing are being allocated and deallocated. Definition of Enable Zombies: Replace deallocated objects with a “zombie” object that traps any attempt to use it. When you send a message to a zombie object, the runtime logs an error and crashes. You can look at the backtrace to see the chain of calls that triggered the zombie detector. 

# draw 

# $curl https://trybindo.com/ --tlsv1.2 --verbose 
  to verify to find if support  tlsv1.2

# NSProxy instance is an object that forwards all selectors to another.

# Error handling:
  NSError *error = nil;
  BOOL ret = [object doSomething:&error]; 
  if (error) {
      // There was an error
  }

  Note: in reality, when using ARC, the compiler translates the NSError** in the method signature to NSError*__autoreleasing*
        The object has to do this because the doSomething: method cannot guarantee that the caller will be able to release the NSError object it created and therefore must add in an autorelease.

  - (BOOL)doSomething:(NSError**)error {
      // Do something that may cause an error
      if ( /* there was an error */ ) { 
          if (error) {
              // Pass the 'error' through the out-parameter
              *error = [NSError errorWithDomain:domain code:code userInfo:userInfo];
          }
          return NO; ///< Indicate failure 
      } else {
          return YES; ///< Indicate success 
      }
  }

# copyWithZone: mutableCopyWithZone:
  Nowadays, every app has a single zone: the default zone. So even though this is the method you need to implement, you do not need to worry about what the zone parameter is.
  Note that the -> syntax has been used here, since the _friends instance variable is internal.

#core data: http://code.tutsplus.com/series/core-data-from-scratch--cms-653

# ATS for iOS: 
  http://useyourloaf.com/blog/app-transport-security.html
  website for ssl test: 
  https://www.ssllabs.com/ssltest/

# set navigation bar / status bar 
  http://motzcod.es/post/110755300272/ios-tip-change-status-bar-icon-text-colors









