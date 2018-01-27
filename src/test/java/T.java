import com.mcl.dao.JobOffersMapper;
import com.mcl.dao.ResumeMapper;
import com.mcl.dao.UserBaseInfoMapper;
import com.mcl.pojo.JobOffers;
import com.mcl.pojo.Resume;
import com.mcl.pojo.UserBaseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class T {

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper ;

    @Autowired
    private ResumeMapper resumeMapper ;

    @Autowired
    private JobOffersMapper jobOffersMapper ;


    @Test
    public void randomJob(){
        String companyid = "082df506-72ae-4fc1-bbb6-40fed11b89ec" ;
        String[] jobs = {"javascript前端开发","java后端开发","python开发","产品经理","产品运营","运维开发"};
        String[] temptations = {"五险一金","美女如云","周末双休","下午茶","不打卡"};
        String[] types = {"互联网","金融","国企","通信","事业单位"};
        String[] citys = {"广州","深圳","上海","南京","厦门","北京"} ;
        String[] jobapplieds = {"腾讯前端","深信服前端","中南海前端","小米前端","美团前端"};
        String[] educations = {"博士后","博士","研究生","博士研究生","神"};

        for(int i=0;i<50;i++){
            String jobname = jobs[(int) (Math.random() * jobs.length)];
            String temptation = temptations[(int) (Math.random() * temptations.length)];
            String tag = temptations[(int) (Math.random() * temptations.length)];
            String type = types[(int) (Math.random() * types.length)];
            Integer wage = (int)(Math.random()*1000);
            String city = citys[(int) (Math.random() * citys.length)];
            String address = citys[(int) (Math.random() * citys.length)] + "的" + jobapplieds[(int)Math.random()*jobapplieds.length];
            String education = educations[(int)Math.random()*educations.length];
            Integer duration = (int)(Math.random() * 10) ;
            Integer workfrequency = (int)(Math.random()* 10 ) ;
            Integer checked = 1;
            String requirements = "技术别的不说，这个一定要骚！";
            String description = "事先说明，不骚不要投简历！骚还不行，至少要比得上谋哥！";
            JobOffers j = new JobOffers();
            j.setChecked(checked);
            j.setJobname(jobname);
            j.setDescription(description);
            j.setCompanyid(companyid);
            j.setAddress(address);
            j.setCity(city);
            j.setDuration(duration);
            j.setEducation(education);
            j.setRequirements(requirements);
            j.setTemptation(temptation);
            j.setWorkfrequency(workfrequency);
            j.setType(type);
            j.setWage(wage);
            j.setTag(tag);
            jobOffersMapper.insert(j);
        }


    }

    @Test
    public void randomResume(){

        String[] skills = {"打球骚","写代码骚","泡妞骚","打击骚"};
        String[] selfs = {"我为人诚恳的骚","热情大方的骚","吃苦耐劳的骚","总之我最骚"};
        String[] schoolnames = {"清华","北大","华师","中大","华工"};
        String[] majors = {"玄学","哲学","工学","儒学"};
        String[] educations = {"博士后","博士","研究生","博士研究生","神"};
        String[] majorclasses = {"js","java","css","vue","nodejs","python"};
        String[] certificates = {"计算机1级证书","计算机2级证书","计算机3级证书","计算机4级证书"};
        String[] awards = {"奖杯0号","奖杯1号","奖杯2号","奖杯3号","奖杯4号","奖杯5号"} ;
        String[] campexps = {"第12次约瑶","第23次约瑶","第44次约瑶","第76次约瑶","第7次约瑶"};
        String[] jobapplieds = {"腾讯前端","深信服前端","中南海前端","小米前端","美团前端"};
        String[] cityapplieds = {"广州","深圳","上海","南京","厦门","北京"} ;


        for(int i =0 ;i<25;i++){
            String openid = "o4THs0Hu3H_e-ZMfVzEGf85VefK8" ;
            //String avatarurl = "https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=d51a24ed9d25bc313f5009ca3fb6e6d4/6609c93d70cf3bc767d23ccfd500baa1cc112ac7.jpg";
            String avatarurl = "a.jpg";
            String resumename = "谋哥第"+i+"骚";
            String city = "天宫"+i+"号" ;
            String province = "皇宫"+i+"号";
            String skill = skills[(int) (Math.random() * skills.length)];
            String self = selfs[(int)(Math.random()*selfs.length)];
            String schoolname = schoolnames[(int)(Math.random()*schoolnames.length)];
            String major = majors[(int)Math.random()*majors.length];
            Date graduationtime = new Date(1530374400);
            String education = educations[(int)Math.random()*educations.length];
            String majorclass = majorclasses[(int)Math.random()*majorclasses.length];
            String certificate = certificates[(int)Math.random()*certificates.length];
            String award = awards[(int)Math.random()*awards.length];
            String campexp = campexps[(int)Math.random()*campexps.length];
            String jobapplied = jobapplieds[(int)Math.random()*jobapplieds.length];
            String cityapplied = cityapplieds[(int)Math.random()*cityapplieds.length];
            Integer wageapplied = (int)Math.random() * 10000 ;
            Integer frequencyapplied = 5 ;
            Integer durationapplied = 10 ;
            Date entrytime = new Date(1530384400);
            String companyname = "亚信科技（中国）有限公司";
            String jobname = "前端开发";
            String jobdesc = "认真的骚啊";
            Date jobstarttime = new Date(1530384400);
            Date jobendtime = new Date(1530384400);
            Resume r = new Resume();
            r.setAvatarurl(avatarurl);
            r.setAwards(award);
            r.setCampusexp(campexp);
            r.setCertificate(certificate);
            r.setCity(city);
            r.setCityapplied(cityapplied);
            r.setCompanyname(companyname);
            r.setDurationapplied(durationapplied);
            r.setEducation(education);
            r.setEntrytime(entrytime);
            r.setFrequencyapplied(frequencyapplied);
            r.setGraduationtime(graduationtime);
            r.setSkills(skill);
            r.setWageapplied(wageapplied);
            r.setSelfevaluation(self);
            r.setResumename(resumename);
            r.setProvince(province);
            r.setOpenid(openid);
            r.setSchoolname(schoolname);
            r.setMajorclass(majorclass);
            r.setMajor(major);
            r.setJobname(jobname);
            r.setJobstarttime(jobstarttime);
            r.setJobendtime(jobendtime);
            r.setJobapplied(jobapplied);
            r.setJobdesc(jobdesc);


            resumeMapper.insert(r);

        }
    }

    @Test
    public void t(){
        for (int i = 0 ; i<50 ;i++){
            UserBaseInfo user = new UserBaseInfo();
            String openid = UUID.randomUUID().toString();
            String nickname = "无敌谋"+i+"号分身";
            String avatarurl = "https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=d51a24ed9d25bc313f5009ca3fb6e6d4/6609c93d70cf3bc767d23ccfd500baa1cc112ac7.jpg";
            Integer gender = 1 ;
            String language = "神仙话";
            String city = "天宫"+i+"号" ;
            String province = "皇宫"+i+"号";
            String realname = nickname ;
            //String birthday = "1996-01-01" ;
            //Date birthday = new Date("1996-01-01");
            String email = "mou@scnu.com" ;
            String phone = "15521329538";
            Double credit = 99.99 ;
            //String startschooltime = "2014-09-07";
            //String endschooltime = "2018-07-01" ;
            //Date startschooltime = new Date("2014-09-07");
            //Date endschooltime = new Date("2018-07-01");
            String education = "博士后";
            String majortype = "玄学";
            Integer isworking = 1 ;
            String schoolname = "华南师范大学" ;
            user.setLanguage(language);
            user.setProvince(province);
            user.setRealname(realname);
            user.setPhone(phone);
            user.setSchoolname(schoolname);
            user.setOpenid(openid);
            user.setNickname(nickname);
            user.setGender(gender);
            user.setAvatarurl(avatarurl);
            //user.setBirthday(new Date(123123));
            user.setCity(city);
            user.setCredit(credit);
            user.setEducation(education);
            user.setEmail(email);
            user.setIsworking(isworking);
            user.setMajortype(majortype);
            // user.setStartschooltime(startschooltime);
            //user.setEndschooltime(endschooltime);
            userBaseInfoMapper.insert(user);
        }
    }
    public static void main(String[] args) {


    }
}
