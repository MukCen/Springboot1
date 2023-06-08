//import java.time.*;
//import java.util.*;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.stereotype.*;
//import ua.com.owu.autoria_springboot.dao.*;
//import ua.com.owu.autoria_springboot.models.*;
//
//@Service
//public class AdService {
//
//    @Autowired
//    private AdRepository adRepository;
//
//    public Map<LocalDate, Integer> getAdViewsByWeek(Integer Id, LocalDate startDate, LocalDate endDate) {
//        Map<LocalDate, Integer> adViewsByWeek = new HashMap<>();
//
//        Ad ad = adRepository.findById(Id).orElse(null);
//        if (ad != null) {
//            List<AdView> adViews = ad.getAdViews();
//
//            for (AdView adView : adViews) {
//                LocalDateTime viewedAt = adView.getViewedAt();
//                LocalDate viewDate = viewedAt.toLocalDate();
//
//                // Фільтруйте перегляди за днями тижня в межах заданого періоду
//                if (viewDate.isAfter(startDate) && viewDate.isBefore(endDate)) {
//                    DayOfWeek dayOfWeek = viewDate.getDayOfWeek();
//
//                    // Отримайте кількість переглядів для поточного дня тижня та додайте до результатів
//                    adViewsByWeek.put(viewDate, adViewsByWeek.getOrDefault(viewDate, 0) + 1);
//                }
//            }
//        }
//
//        return adViewsByWeek;
//    }
//
//    public Map<YearMonth, Integer> getAdViewsByMonth(Integer Id, YearMonth startDate, YearMonth endDate) {
//        Map<YearMonth, Integer> adViewsByMonth = new HashMap<>();
//
//        Ad ad = adRepository.findById(Id).orElse(null);
//        if (ad != null) {
//            List<AdView> adViews = ad.getAdViews();
//
//            for (AdView adView : adViews) {
//                LocalDateTime viewedAt = adView.getViewedAt();
//                LocalDate viewDate = viewedAt.toLocalDate();
//
//                // Фільтруйте перегляди за місяцями в межах заданого періоду
//                YearMonth yearMonth = YearMonth.from(viewDate);
//                if (yearMonth.isAfter(startDate) && yearMonth.isBefore(endDate)) {
//                    // Отримайте кількість переглядів для поточного місяця та додайте до результатів
//                    adViewsByMonth.put(yearMonth, adViewsByMonth.getOrDefault(yearMonth, 0) + 1);
//                }
//            }
//        }
//
//        return adViewsByMonth;
//    }
//
//    // Інші методи сервісу
//
//    public void saveAd(Ad ad) {
//        adRepository.saveAd(ad);
//    }
// 
//        
//
// 
//
//}
