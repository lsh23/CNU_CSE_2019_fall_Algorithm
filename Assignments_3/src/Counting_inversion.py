
def mergy_sort(list):
    if(len(list) == 1):
        return list
    len_of_list = len(list)
    r_list = mergy_sort(list[:int((len_of_list/2))])
    l_list = mergy_sort(list[int((len_of_list/2)):])

    len_r_list_end_index = len(r_list) - 1
    len_l_list_end_index = len(l_list) - 1

    mergyed_list = []

    count = 0
    i = 0
    j = 0

    while(count != len_of_list):
        if(i > len_r_list_end_index):
            while(j <= len_l_list_end_index):
                mergyed_list.append(l_list[j])
                j = j + 1
                count = count + 1
            break
        if(j > len_l_list_end_index):
            while(i <= len_r_list_end_index):
                mergyed_list.append(r_list[i])
                i = i + 1
                count = count + 1
            break
        if(r_list[i] > l_list[j]):
            mergyed_list.append(l_list[j])
            j = j + 1
            count = count + 1
        else:
            mergyed_list.append(r_list[i])
            i = i + 1
            count = count + 1

    return mergyed_list


def sort_and_count(list):
    len_of_list = len(list)
    if(len_of_list == 1):
        return 0, list

    l_count, l_list = sort_and_count(list[:int((len_of_list/2))])
    r_count, r_list = sort_and_count(list[int((len_of_list/2)):])



    inversion_count = 0
    l_index = 0
    r_index = 0

    l_length = len(l_list)
    r_length = len(r_list)

    mergyed_list = []

    while(l_length !=0 and r_length !=0):
        if(l_list[l_index] > r_list[r_index]):
            inversion_count = inversion_count + l_length
            mergyed_list.append(r_list[r_index])
            r_index = r_index +1
            r_length = r_length -1
        else:
            mergyed_list.append(l_list[l_index])
            l_index = l_index +1
            l_length = l_length -1

    if(l_length == 0):
        while(r_length !=0):
            mergyed_list.append(r_list[r_index])
            r_index = r_index +1
            r_length = r_length -1
    if(r_length == 0):
        while(l_length !=0):
            mergyed_list.append(l_list[l_index])
            l_index = l_index +1
            l_length = l_length -1


    return l_count + r_count + inversion_count , mergyed_list

# import time
# start = time.time()
#
# print(mergy_sort([1381,20144,2937,8401,31904,22750,27539,6615,1492,8110,12833,11891,25449,14327,19563,21346,16756,16012,16590,7966,8155,10696,2560,18444,10171,22890,14236,21239,28678,22691,30682,1469,30065,1646,28317,29256,18829,6176,32180,11712,15667,10816,25177,2047,2598,21400,19454,22342,16372,28300]))
#
# for x in range(1000):
#     mergy_sort([1381,20144,2937,8401,31904,22750,27539,6615,1492,8110,12833,11891,25449,14327,19563,21346,16756,16012,16590,7966,8155,10696,2560,18444,10171,22890,14236,21239,28678,22691,30682,1469,30065,1646,28317,29256,18829,6176,32180,11712,15667,10816,25177,2047,2598,21400,19454,22342,16372,28300])
#
# print("time : ", time.time() - start)

print(sort_and_count([1,5,4,8,10,2,6,9,12,11,3,7]))
