# Photo Manager Collections Project

## Project Structure

```
collections/
├── src/
│   ├── Main.java                 # Demo application
│   ├── photo/
│   │   └── Photo.java            # Photo data model
│   └── manager/
│       └── PhotoManager.java     # Photo management and search engine
└── collections.iml               # IntelliJ project file
```

## Class Overview

### Photo.java
Represents a photo object with metadata.

**Properties:**
- `id: String` - Unique photo identifier
- `fileName: String` - Name of the photo file
- `date: LocalDate` - Date the photo was taken
- `location: String` - Location where photo was taken
- `tags: Set<String>` - Set of tags for categorization

### PhotoManager.java
Manages photo collection and provides efficient search capabilities using hash maps for indexing.

**Data Structures:**
- `photos: ArrayList<Photo>` - All uploaded photos in order
- `tagMap: HashMap<String, ArrayList<Photo>>` - Index photos by tag
- `dateMap: HashMap<LocalDate, ArrayList<Photo>>` - Index photos by date
- `locationMap: HashMap<String, ArrayList<Photo>>` - Index photos by location

### Main.java
Demo application showing upload and search operations.

---

## Time Complexity Analysis

### PhotoManager Operations

#### `uploadPhoto(Photo photo)`
**Time Complexity: O(t)** where t = number of tags in the photo
- Add photo to `photos` ArrayList: **O(1)** amortized
- Iterate through tags and add to `tagMap`: **O(t)** 
- Add to `dateMap`: **O(1)** 
- Add to `locationMap`: **O(1)**

**Total: O(t)**

**Space Complexity: O(n + m)** where n = total photos, m = total tag occurrences

---

#### `searchByTag(String tag)`
**Time Complexity: O(1)**
- Direct HashMap lookup by tag key: **O(1)**
- Returns reference to ArrayList of photos

**Space Complexity: O(1)** - returns reference to existing data

---

#### `searchByDate(LocalDate date)`
**Time Complexity: O(1)**
- Direct HashMap lookup by date key: **O(1)**
- Returns reference to ArrayList of photos

**Space Complexity: O(1)** - returns reference to existing data

---

#### `searchByLocation(String location)`
**Time Complexity: O(1)**
- Direct HashMap lookup by location key: **O(1)**
- Returns reference to ArrayList of photos

**Space Complexity: O(1)** - returns reference to existing data

---

#### `searchByMultipleTags(Set<String> tags)`
**Time Complexity: O(n * t + p * log p)** where n = number of tags to search, t = average photos per tag, p = average intersection size
- Iterate through tags: O(n)
- For each tag, get ArrayList from HashMap: O(1)
- Convert to HashSet: O(t)
- Intersection operation (retainAll): O(p) where p = intersection size
- Multiple retainAll operations: O(n * p)

**Total: O(n * t + n * p)** simplified to **O(n * (t + p))**

**Space Complexity: O(p)** - for result HashSet

---

## Summary Table

| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| `uploadPhoto()` | O(t) | O(n + m) |
| `searchByTag()` | O(1) | O(1) |
| `searchByDate()` | O(1) | O(1) |
| `searchByLocation()` | O(1) | O(1) |
| `searchByMultipleTags()` | O(n * (t + p)) | O(p) |

**Legend:**
- n = number of tags in search/total items
- t = average photos per tag
- m = total tag occurrences
- p = intersection size

---

## Data Structure Choices

| Collection | Purpose | Why Used |
|-----------|---------|----------|
| `ArrayList<Photo>` | Store all photos sequentially | Fast random access, maintains insertion order |
| `HashMap<K, ArrayList<Photo>>` | Index photos by key (tag/date/location) | O(1) lookups by key, efficient multi-value mapping |
| `HashSet<Photo>` | Find tag intersection | O(1) contains check, efficient set operations |

