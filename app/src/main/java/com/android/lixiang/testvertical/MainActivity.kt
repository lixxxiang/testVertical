package com.android.lixiang.testvertical

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import q.rorbin.verticaltablayout.VerticalTabLayout
import q.rorbin.verticaltablayout.widget.QTabView
import q.rorbin.verticaltablayout.widget.TabView

class MainActivity : AppCompatActivity() {
    var listTitle: MutableList<String>? = mutableListOf()
    var listFragment: MutableList<Fragment>? = mutableListOf()
    private var fAdapter: FragmentPagerAdapter? = null
    private var list: MutableList<Int>? = null
    private var scrollPosition = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val goodsDelegate = BlankFragment1()
        val contentDelegate = BlankFragment2()
        listFragment!!.add(goodsDelegate)
        listFragment!!.add(contentDelegate)

        listTitle!!.add("ggg")
        listTitle!!.add("ggggggg")



        viewpager.setDirection(YViewPager.VERTICAL)


        viewpager.adapter = Find_tab_Adapter(supportFragmentManager, listFragment, listTitle)
        tablayout.addTab(QTabView(this))
        tablayout.setupWithViewPager(viewpager)

        tablayout.addOnTabSelectedListener(object : VerticalTabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabView, position: Int) {
                viewpager.setCurrentItem(position, true)
            }


            override fun onTabReselected(tab: TabView, position: Int) {
            }
        })

        viewpager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            //选择当前的图片
            override fun onPageSelected(position: Int) {
                // TODO Auto-generated method stub
                //通过的到图片选中的位置去设置radioButton
//                when (position % list!!.size) {
//                    else -> {
//                    }
//                }
//                if (scrollPosition != position) {
//                    Ladapter!!.setSelectItem(position)
//                    mLeftLV!!.setSelectionFromTop(position, 40)
//                    scrollPosition = position
//                }
            }

            //
            override fun onPageScrolled(position: Int, positionOffset: Float,
                                        positionOffsetPixels: Int) {
                // TODO Auto-generated method stub
                //偏移值
                //        Log.i("TAG", "positionOffset"+positionOffset);
                //        Log.i("TAG", "positionOffsetPixels"+positionOffsetPixels);


            }
            //还动改变的方法
            /***
             *
             * ViewPager#SCROLL_STATE_IDLE   停止   0
             * ViewPager#SCROLL_STATE_DRAGGING  拖动   1
             * ViewPager#SCROLL_STATE_SETTLING  弹回   2
             *
             */
            override fun onPageScrollStateChanged(state: Int) {
                // TODO Auto-generated method stub
                //        Log.i("TAG", "state"+state);
            }
        })
    }
}
