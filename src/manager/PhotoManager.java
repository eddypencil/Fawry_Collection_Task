package manager;

import photo.Photo;

import java.time.LocalDate;
import java.util.*;

public class PhotoManager {
    ArrayList<Photo> photos = new ArrayList<>();
    HashMap<String, ArrayList<Photo>> tagMap = new HashMap<>();
    HashMap<LocalDate, ArrayList<Photo>> dateMap = new HashMap<>();
    HashMap<String, ArrayList<Photo>> locationMap = new HashMap<>();


    private<T> void hashMapKeyExistCheckAndAdd(T key, Map<T,ArrayList<Photo>> map , Photo photo){
        if (map.containsKey(key)) {
            map.get(key).add(photo);
        } else {
            ArrayList<Photo> photoList =new ArrayList<>();
            photoList.add(photo);
            map.put(key,photoList);
        }

    }

    public void uploadPhoto(Photo photo) {
        photos.add(photo);

        //tags
        Set<String> tags = photo.getTags();
        for (String tag : tags) {
            hashMapKeyExistCheckAndAdd(tag,tagMap,photo);
        }

        hashMapKeyExistCheckAndAdd(photo.getDate(),dateMap,photo);

        hashMapKeyExistCheckAndAdd(photo.getLocation(),locationMap,photo);

    }

    public List<Photo> searchByTag(String tag) {
        return tagMap.get(tag);
    }


    public ArrayList<Photo> searchByDate(LocalDate date){
        return dateMap.get(date);
    }

    public ArrayList<Photo> searchByLocation(String location) {
        return locationMap.get(location);
    }

    public ArrayList<Photo> searchByMultipleTags(Set<String> tags) {
        //old way
//        boolean first = true;
//        Set<Photo> result = new HashSet<>();
//
//        for (String tag : tags) {
//            List<Photo> list = tagMap.get(tag);
//            if (list == null) {
//                return new HashSet<>();
//            }
//            if (first) {
//                result.addAll(list);
//                first = false;
//            } else {
//                Set<Photo> set = new HashSet<>(list);
//                result.retainAll(set);
//            }
//        }
//
//        return result;
//    }

        if (tags.isEmpty()){
            ArrayList<Photo> empty = new ArrayList<>();
            return empty;
        }
        ArrayList<Photo> result = new ArrayList<>();
        for(Photo photo :photos){
            if(photo.getTags().containsAll(tags)){
                result.add(photo);
            }
        }

        return result;

}}
