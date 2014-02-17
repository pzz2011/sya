package com.github.magicsky.sya.unittests.checkers.style;

import com.github.magicsky.sya.enumerators.CheckType;
import com.github.magicsky.sya.model.CheckResult;
import com.github.magicsky.sya.unittests.checkers.BaseTest;
import com.github.magicsky.sya.unittests.checkers.IChecker;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class AutoPtrCheckerTest extends BaseTest {

    private IChecker checker = new AutoPtrChecker();

//    // 测试当使用auto_ptr
//    #include <iostream>
//    #include <memory>
//    using namespace std;
//
//    int main () {
//      auto_ptr<int> p1 (new int);
//      *p1.get()=10;
//
//      auto_ptr<int> p2 (p1);  // auto_ptr in here
//
//      cout << "p2 points to " << *p2 << "\n";
//      // (p1 is now null-pointer auto_ptr)
//
//      return 0;
//    }
    public void testUsingAutoPtr() {
        String code = getCommentAbove();
        IASTTranslationUnit translationUnit = parseCPP(code);
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertTrue(checkResults.size() > 0);
        CheckResult checkResult = checkResults.get(0);
        assertEquals(CheckType.AUTO_PTR.getValue(), checkResult.getType().getValue());
    }

//    // 测试当使用std::auto_ptr
//    #include <iostream>
//    #include <memory>
//
//    int main () {
//      std::auto_ptr<int> p1 (new int);
//      *p1.get()=10;
//
//      std::auto_ptr<int> p2 (p1);  // auto_ptr in here
//
//      std::cout << "p2 points to " << *p2 << "\n";
//      // (p1 is now null-pointer auto_ptr)
//
//      return 0;
//    }
    public void testUsingAutoPtrWithNamespace() {
        String code = getCommentAbove();
        IASTTranslationUnit translationUnit = parseCPP(code);
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertTrue(checkResults.size() > 0);
        CheckResult checkResult = checkResults.get(0);
        assertEquals(CheckType.AUTO_PTR.getValue(), checkResult.getType().getValue());
    }
}
