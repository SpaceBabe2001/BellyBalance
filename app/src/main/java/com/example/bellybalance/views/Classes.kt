package com.example.bellybalance.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bellybalance.SignUpActivity
import com.example.bellybalance.ui.theme.BellyBalanceTheme

// Class for WelcomeScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                WelcomeScreen()
            }
        }
    }
}

// Class for LoginScreen
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(userViewModel)
                }
            }
        }
    }
}

// Class for SignUpScreen
class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpActivity(userViewModel)
                }
            }
        }
    }
}

// Class for ReportsScreen
class MainpageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReportsScreen(userViewModel)
                }
            }
        }
    }
}

// Class for FoodScreen
class FoodActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodScreen()
                }
            }
        }
    }
}

// Class for ConditionsScreen
class ConditionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConditionsScreen()
                }
            }
        }
    }
}

// Class for PoopScreen
class PoopActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PoopScreen()
                }
            }
        }
    }
}

// Class for StoolChartScreen
class StoolChartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StoolChartScreen()
                }
            }
        }
    }
}

// Class for CalenderScreen
class CalenderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalenderScreen()
                }
            }
        }
    }
}

// Class for AnalysisScreen
class AnalyseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnalysisScreen()
                }
            }
        }
    }
}

// Class for SettingsScreen
class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SettingsScreen()
                }
            }
        }
    }
}

// Class for UpgradeLoggedInScreen
class UpgradeLoggedinActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UpgradeLoggedInScreen()
                }
            }
        }
    }
}

// Class for UpgradeLoggedOutScreen
class UpgradeLoggedOutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BellyBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UpgradeLoggedOutScreen()
                }
            }
        }
    }
}
