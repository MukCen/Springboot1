package ua.com.owu.autoria_springboot.services;


import java.time.*;
import lombok.*;
import org.springframework.stereotype.*;
import ua.com.owu.autoria_springboot.dao.*;
import ua.com.owu.autoria_springboot.models.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
@Service
@AllArgsConstructor
public class AdService {
    private AdRepository adRepository;
//    private ua.com.owu.autoria_springboot.dao.AdViewRepository adViewRepository;
   
    
    // Інші методи сервісу
    
//    public Map<LocalDate, Integer> getAdViewsByDay(Integer Id
//            , LocalDate startDate, LocalDate endDate) {
//        Map<LocalDate, Integer> adViewsByDay = new HashMap<>();
//        
//        Ad ad = adRepository.findById(Id
//        ).orElse(null);
//        if (ad != null) {
//            List<AdView> adViews = ad.getAdViews();
//            
//            for (AdView adView : adViews) {
//                LocalDateTime viewedAt = adView.getViewedAt();
//                LocalDate viewDate = viewedAt.toLocalDate();
//                
//                if (viewDate.isAfter(startDate) && viewDate.isBefore(endDate)) {
//                    adViewsByDay.put(viewDate, adViewsByDay.getOrDefault(viewDate, 0) + 1);
//                }
//            }
//        }
//        
//        return adViewsByDay;
//    }
//    
//
//
//public Map<YearMonth, Integer> getAdViewsByMonth(Integer Id
//        , YearMonth startYearMonth, YearMonth endYearMonth) {
//    Map<YearMonth, Integer> adViewsByMonth = new HashMap<>();
//    
//    Ad ad = adRepository.findById(Id
//    ).orElse(null);
//    if (ad != null) {
//        List<AdView> adViews = ad.getAdViews();
//        
//        for (AdView adView : adViews) {
//            LocalDateTime viewedAt = adView.getViewedAt();
//            LocalDate viewDate = viewedAt.toLocalDate();
//            YearMonth yearMonth = YearMonth.from(viewDate);
//            
//            if (yearMonth.isAfter(startYearMonth) && yearMonth.isBefore(endYearMonth)) {
//                adViewsByMonth.put(yearMonth, adViewsByMonth.getOrDefault(yearMonth, 0) + 1);
//            }
//        }
//    }
//    
//    return adViewsByMonth;
//}

    public int getAdViewsForDay(Integer Id) {
        Ad ad = adRepository.findById(Id).orElse(null);
        if (ad != null) {
            return (int) ad.getAdViews().stream()
                    .filter(adView -> adView.getViewedAt().toLocalDate().isEqual(LocalDate.now()))
                    .count();
        }
        return 0;
    }

    public int getAdViewsForWeek(Integer Id) {
        Ad ad = adRepository.findById(Id).orElse(null);
        if (ad != null) {
            LocalDate startDate = LocalDate.now().minusDays(7);
            return (int) ad.getAdViews().stream()
                    .filter(adView -> adView.getViewedAt().toLocalDate().isAfter(startDate))
                    .count();
        }
        return 0;
    }

    public int getAdViewsForMonth(Integer Id) {
        Ad ad = adRepository.findById(Id).orElse(null);
        if (ad != null) {
            LocalDate startDate = LocalDate.now().minusMonths(1);
            return (int) ad.getAdViews().stream()
                    .filter(adView -> adView.getViewedAt().toLocalDate().isAfter(startDate))
                    .count();
        }
        return 0;
    }

    // ...


 public Ad saveAd(Ad ad) {
        // Виконати потрібну логіку перед збереженням оголошення
        // Наприклад, перевірки, обробка даних і т.д.
        
        // Зберегти оголошення
        return adRepository.save(ad);
    }
 public Ad getAdById(Integer Id) {
    return adRepository.findById(Id).orElse(null);
}
//public void  saveAdView(AdView adView) {
//        // Логіка для збереження об'єкта AdView у базі даних
//        // Наприклад, використання adViewRepository для збереження
//        
//        adViewRepository.save(adView);
//    }
// 
 
 

    public void incrementViews(Integer Id) {
        Ad ad = adRepository.findById(Id).orElse(null);
        if (ad != null) {
            AdView adView = new AdView();
            adView.setAd(ad);
            adView.setViewedAt(LocalDateTime.now());
            ad.getAdViews().add(adView);
            adRepository.save(ad);
        }
    }
}

